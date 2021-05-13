package manejoformulario.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manejoformulario.Dao.PersonaDao;

/**
 * Servlet Filter implementation class FiltroLogin
 */
@WebFilter({"/FiltroLogin"})
public class FiltroLogin implements Filter {

	/**
	 * Default constructor.
	 */
	public FiltroLogin() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpSession sesion = ((HttpServletRequest) request).getSession();

		if (sesion.getAttribute("usuario") != null) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse)response).sendRedirect("/ManejoFormulario/index.jsp");
			System.out.println("No estas autorizado");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
