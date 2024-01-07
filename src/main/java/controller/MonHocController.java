package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.MonHocDAO;
import daos.TheLoaiDAO;
import daos.TinChiDAO;
import models.monhoc;
import models.theloai;
import models.tinchi;

@WebServlet(urlPatterns = {"/mon-hoc"})
public class MonHocController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MonHocController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		
		MonHocDAO monHocDAO = new MonHocDAO();
		List<monhoc> monHocList = monHocDAO.findAll();
		request.setAttribute("monHocList", monHocList);
		
		TinChiDAO tinchiDAO = new TinChiDAO();
		List<tinchi> tinchiList = tinchiDAO.findAll();
		request.setAttribute("tinchiList", tinchiList);
		
		TheLoaiDAO theloaiDAO = new TheLoaiDAO();
		List<theloai> theloaiList = theloaiDAO.findAll();
		request.setAttribute("theloaiList", theloaiList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/monhoc.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		MonHocDAO monHocDAO = new MonHocDAO();
		
		String maMH = request.getParameter("maMH");
		
		String tenMH = request.getParameter("tenMH");
		
		String maTC = request.getParameter("maTC");
		
		String maTL = request.getParameter("maTL");
		
		monhoc objMH = new monhoc(maMH, tenMH, new tinchi(maTC, 0), new theloai(maTL, null));
		int add = monHocDAO.add(objMH);
		if(add > 0) {
			response.sendRedirect(request.getContextPath()+"/mon-hoc?msg=OK");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/mon-hoc?msg=ERROR");
			return;
		}
		
	}

}
