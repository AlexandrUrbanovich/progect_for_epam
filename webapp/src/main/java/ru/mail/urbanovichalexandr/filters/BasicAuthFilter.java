package ru.mail.urbanovichalexandr.filters;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ru.mail.urbanovichalexandr.services.impl.UserAuthStorage;
import ru.mail.urbanovichalexandr.servises.IUserServices;

public class BasicAuthFilter implements Filter {

	public static final Map<String, Integer> USERS_DB = new HashMap<>();
	static Connection connection = null;
	private IUserServices userServices;
	private ApplicationContext applicationContext;

	static {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/progect_for_epam", "postgres",
					"root");

			Statement createStatement = connection.createStatement();
			createStatement.execute("select users.login, users.password from users order by user_id");

			ResultSet resultSet = createStatement.getResultSet();
			resultSet.next();

			while (resultSet.next()) {
				USERS_DB.put(resultSet.getString(0), resultSet.getInt(1));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(filterConfig.getServletContext());
		userServices = context.getBean(IUserServices.class);
		applicationContext = context;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if (!isAuthRequired(req)) {
            chain.doFilter(request, response);
        }
        
        UserAuthStorage userDataStorage = applicationContext.getBean(UserAuthStorage.class);
        
        String[] credentials = resolveCredentials(req);
        
        boolean isCredentialsResolved = credentials != null && credentials.length == 2;
        if (!isCredentialsResolved) {
            res.sendError(401);
            return;
        }
        
        String username = credentials[0];
        String password = credentials[1];
        
        Integer login = USERS_DB.get(username);
        if (validateUserPassword(login, password)) {

            userDataStorage.setLogin(login);
            chain.doFilter(request, response);
        } else {
            res.sendError(401);
        }
        
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	private boolean isAuthRequired(HttpServletRequest req) {
		if (req.getMethod().toUpperCase().equals("GET")) {
			return false;
		}
		// TODO other variants
		return true;
	}

	private String[] resolveCredentials(HttpServletRequest req) {
		try {
			Enumeration<String> headers = req.getHeaders("Authorization");
			String nextElement = headers.nextElement();
			String base64Credentials = nextElement.substring("Basic".length()).trim();
			String credentials = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"));
			return credentials.split(":", 2);
		} catch (Exception e) {
			return null;
		}
	}

	private boolean validateUserPassword(Integer login, String password) {
		// TODO get user from DB by username and check password
		if (login == null) {
			return false;
		}

		return "password".equals(password);
	}

}
