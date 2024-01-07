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

import daos.LopDAO;
import daos.SinhVienDAO;
import models.Khoa;
import models.Lop;
import models.sinhvien;

@WebServlet(urlPatterns = {"/sinh-vien"})
public class SinhVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SinhVienController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		
		SinhVienDAO sinhvienDAO = new SinhVienDAO();
		List<sinhvien> sinhvienList = sinhvienDAO.findAll();
		request.setAttribute("sinhvienList", sinhvienList);
		
		LopDAO lopDAO = new LopDAO();
		List<Lop> lopList = lopDAO.findAll();
		request.setAttribute("lopList", lopList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/sinhvien.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String action = request.getParameter("action");

	    if ("delete".equals(action)) {
	        // Xử lý yêu cầu xóa sinh viên
	        int masv = Integer.parseInt(request.getParameter("masv"));
	        SinhVienDAO sinhvienDAO = new SinhVienDAO();
	        int deleteResult = sinhvienDAO.delete(masv);

	        if (deleteResult > 0) {
	            // Gửi phản hồi xóa thành công
	            response.getWriter().write("Xóa thành công");
	        } else {
	            // Gửi phản hồi xóa thất bại
	            response.getWriter().write("Xóa thất bại");
	        }
	    } else if ("edit".equals(action)) {
	        // Xử lý yêu cầu sửa sinh viên
	        int masv = Integer.parseInt(request.getParameter("masv"));
	        String tensv = request.getParameter("tensv");
	        String diachi = request.getParameter("diachi");
	        int sdt = Integer.parseInt(request.getParameter("sdt"));
	        String email = request.getParameter("email");
	        int malop = Integer.parseInt(request.getParameter("malop"));

	        sinhvien objSV = new sinhvien(masv, tensv, diachi, sdt, email, 
	                new Lop(malop, null,
	                        new Khoa(null, null, null)));

	        SinhVienDAO sinhvienDAO = new SinhVienDAO();
	        int editResult = sinhvienDAO.edit(objSV);

	        if (editResult > 0) {
	            // Gửi phản hồi sửa thành công
	            response.sendRedirect(request.getContextPath() + "/sinh-vien?msg=OK");
	        } else {
	            // Gửi phản hồi sửa thất bại
	            response.sendRedirect(request.getContextPath() + "/sinh-vien?msg=ERROR");
	        }
	    }
	    else {
	        // Xử lý các trường hợp khác (thêm sinh viên, ...)
	        response.setContentType("text/html");
	        response.setCharacterEncoding("UTF-8");
	        request.setCharacterEncoding("UTF-8");

	        // Lấy thông tin sinh viên từ request và khởi tạo objSV
	        int masv = Integer.parseInt(request.getParameter("masv"));
	        String tensv = request.getParameter("tensv");
	        String diachi = request.getParameter("diachi");
	        int sdt = Integer.parseInt(request.getParameter("sdt"));
	        String email = request.getParameter("email");
	        int malop = Integer.parseInt(request.getParameter("malop"));

	        sinhvien objSV = new sinhvien(masv, tensv, diachi, sdt, email, 
	                new Lop(malop, null,
	                        new Khoa(null, null, null)));

	        SinhVienDAO sinhvienDAO = new SinhVienDAO();
	        int addResult = sinhvienDAO.add(objSV);

	        if (addResult > 0) {
	            // Gửi phản hồi thêm thành công
	            response.sendRedirect(request.getContextPath() + "/sinh-vien?msg=OK");
	        } else {
	            // Gửi phản hồi thêm thất bại
	            response.sendRedirect(request.getContextPath() + "/sinh-vien?msg=ERROR");
	        }
	    }
	}


}
