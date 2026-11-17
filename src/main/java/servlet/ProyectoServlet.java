package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entidades.Proyectos;

/**
 * Servlet implementation class ProyectoServlet
 */
@WebServlet("/ProyectoServlet")
public class ProyectoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Proyectos> listaProyectos = new ArrayList<Proyectos>();
	private int contadorId = 1;
	
	/**
     * @see HttpServlet#HttpServlet()
     */

	public ProyectoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		if ("listar".equals(request.getParameter("accion"))) {
			request.setAttribute("proyectos", listaProyectos);
			request.getRequestDispatcher("/muniLima.jsp").forward(request, response);
			return;
		}

		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String fecInicio = request.getParameter("fecInicio");
		String fecCulminacion = request.getParameter("fecCulminacion");
		String asesor = request.getParameter("asesor");
		String presupuestoTexto = request.getParameter("presupuesto");

		String error = "";
		double presupuesto = 0;

		if (nombre == null || nombre.trim().length() < 4 || nombre.trim().length() > 60) {
			error = "El nombre debe tener entre 4 y 60 caracteres.";
		} else if (fecInicio == null || fecInicio.isEmpty() || fecCulminacion == null || fecCulminacion.isEmpty()) {
			error = "Las fechas de inicio y culminacion son obligatorias.";
		} else if (asesor == null || asesor.trim().isEmpty()) {
			error = "El asesor tecnico es obligatorio.";
		} else if (presupuestoTexto == null || presupuestoTexto.trim().isEmpty()) {
			error = "El presupuesto es obligatorio.";
		} else {
			try {
				presupuesto = Double.parseDouble(presupuestoTexto);
				if (!Double.isFinite(presupuesto) || presupuesto <= 0) {
					error = "El presupuesto debe ser mayor que cero.";
				}
			} catch (NumberFormatException e) {
				error = "El presupuesto debe ser numerico.";
			}
		}

		if (error.isEmpty()) {
			if (descripcion == null) {
				descripcion = "";
			}
			Proyectos proyecto = new Proyectos(contadorId++, nombre.trim(), descripcion,
					fecInicio, fecCulminacion, asesor.trim(), presupuesto);
			listaProyectos.add(proyecto);
			request.setAttribute("mensaje", "Proyecto registrado correctamente.");
		} else {
			request.setAttribute("error", error);
		}

		request.setAttribute("proyectos", listaProyectos);
		request.getRequestDispatcher("/muniLima.jsp").forward(request, response);
	}
}
