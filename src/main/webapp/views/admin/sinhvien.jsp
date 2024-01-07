<%@page import="models.Lop"%>
<%@page import="models.sinhvien"%>
<%@page import="models.giangvien"%>
<%@page import="models.namhoc"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/templates/admin/inc/header.jsp" %>

  <!-- Main Sidebar Container -->
  <%@include file="/templates/admin/inc/menu.jsp" %>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Sinh viên</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
              <li class="breadcrumb-item active">Sinh viên</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
      <%
		if(!"".equals(request.getParameter("msg"))){
			String msg = request.getParameter("msg");
			if("OK".equals(msg)){
				%>
					<div class="alert alert-success" role="alert">
						 Xử lý thành công..!
					</div>
				<%
			}
		}
	%>
	<%
		if(!"".equals(request.getParameter("msg"))){
			String msg = request.getParameter("msg");
			if("ERROR".equals(msg)){
				%>
					<div class="alert alert-success" role="alert">
						 Xử lý thất bại..!
					</div>
				<%
			}
		}
	%>
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalThem">Thêm</button>
	<table class="table table-bordered" id="datatable">
	  <thead class="thead-CCFFFF">
	    <tr class="list-header">
	      <th scope="col">#</th>
	      <th scope="col">Mã Sinh viên</th>
	      <th scope="col">Tên Sinh viên</th>
	      <th scope="col">Địa chỉ</th>
	      <th scope="col">Số điện thoại</th>
	      <th scope="col">Lớp</th>
	      <th scope="col">Chức năng</th>
	    </tr>
	  </thead>
	  <tbody>
	  <%
	  if(request.getAttribute("sinhvienList") != null){
		  List<sinhvien> sinhvienList = (List<sinhvien>) request.getAttribute("sinhvienList");
		  if(sinhvienList.size() > 0){
			  for(sinhvien objSV : sinhvienList){
				  %>
		<tr class="tr-hover">
	      <th scope="row"><input type="checkbox" name="vehicle1" value="Bike"></th>
	      <td><%=objSV.getMaSV() %></td>
	      <td><%=objSV.getTenSV() %></td>
	      <td><%=objSV.getDiaChi() %></td>
	      <td><%=objSV.getSdt() %></td>
	      <td><%=objSV.getLop().getTenLop() %></td>
		<td>
		   <button type="button" class="btn btn-warning suaMenu" data-toggle="modal" data-target="#exampleModalSua"
        onclick="editStudent(<%=objSV.getMaSV()%>, '<%=objSV.getTenSV()%>', '<%=objSV.getDiaChi()%>', <%=objSV.getSdt()%>, '<%=objSV.getEmail()%>', <%=objSV.getLop().getMaLop()%>)">
        Sửa
    </button>
		    <button type="button" class="btn btn-danger" onclick="deleteStudent(<%=objSV.getMaSV()%>)">Xóa</button>
		</td>

	    </tr>
				  <%
			  }
		  }
	  }
	  %>
	  </tbody>
	</table>
	
			      	
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
    <!-- Modal -->
<div class="modal fade" id="modalThem" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Thêm sinh viên</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action ="<%=request.getContextPath()%>/sinh-vien" method="post">
        
        	<div class="form-group row">
			    <label for="exampleFormControlFile1" class="col-sm-3">Mã sinh viên</label>
			    <input type="text" class="form-control-file col-sm-8" id="exampleFormControlFile1" name="masv">
			  </div>
			  <div class="form-group row">
			    <label for="exampleFormControlFile1" class="col-sm-3">Tên sinh viên</label>
			    <input type="text" class="form-control-file col-sm-8" id="exampleFormControlFile1" name="tensv">
			  </div>
			  <div class="form-group row">
			    <label for="exampleFormControlFile1" class="col-sm-3">Địa chỉ</label>
			    <input type="text" class="form-control-file col-sm-8" id="exampleFormControlFile1" name="diachi">
			  </div>
			  <div class="form-group row">
			    <label for="exampleFormControlFile1" class="col-sm-3">Số điện thoại</label>
			    <input type="text" class="form-control-file col-sm-8" id="exampleFormControlFile1" name="sdt">
			  </div>
			  <div class="form-group row">
			    <label for="exampleFormControlFile1" class="col-sm-3">Email</label>
			    <input type="text" class="form-control-file col-sm-8" id="exampleFormControlFile1" name="email">
			  </div>
			  <div class="form-group row">
			    <label for="exampleFormControlFile1" class="col-sm-3">Lớp</label>
			    <%
			    	if(request.getAttribute("lopList") != null){
			    		List<Lop> lopList = (List<Lop>) request.getAttribute("lopList");
			    		if(lopList.size() > 0){
			    			%>
			    <select class="form-control" id="exampleFormControlSelect1" name="malop">
			    <%
			    	for(Lop objLop : lopList){
			    		%>
			    	<option value="<%=objLop.getMaLop()%>"><%=objLop.getTenLop()%></option>
			    		<%
			    	}
			    %>
			    </select>
			    			<%
			    		}
			    	}
			    %>
			  </div>
			<div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Thoát</button>
		        <button type="submit" class="btn btn-primary">Thêm</button>
		      </div>        
        </form>
      </div>
    </div>
  </div>
</div>
<form action="<%=request.getContextPath()%>/sinh-vien" method="post">
    <input type="hidden" name="action" value="edit">
    <input type="hidden" id="editMaSV" name="masv">

    <div class="form-group row">
        <label for="editTenSV" class="col-sm-3">Tên sinh viên</label>
        <div class="col-sm-9">
            <input type="text" class="form-control" id="editTenSV" name="tensv" required>
        </div>
    </div>
    <div class="form-group row">
        <label for="editDiaChi" class="col-sm-3">Địa chỉ</label>
        <div class="col-sm-9">
            <input type="text" class="form-control" id="editDiaChi" name="diachi" required>
        </div>
    </div>
    <div class="form-group row">
        <label for="editSDT" class="col-sm-3">Số điện thoại</label>
        <div class="col-sm-9">
            <input type="text" class="form-control" id="editSDT" name="sdt" required>
        </div>
    </div>
    <div class="form-group row">
        <label for="editEmail" class="col-sm-3">Email</label>
        <div class="col-sm-9">
            <input type="text" class="form-control" id="editEmail" name="email" required>
        </div>
    </div>
    <div class="form-group row">
        <label for="editMaLop" class="col-sm-3">Lớp</label>
        <div class="col-sm-9">
            <select class="form-control" id="editMaLop" name="malop" required>
                <!-- Lựa chọn các lớp từ danh sách lớp đã có -->
                <% if(request.getAttribute("lopList") != null){
                    List<Lop> lopList = (List<Lop>) request.getAttribute("lopList");
                    if(lopList.size() > 0){
                        for(Lop objLop : lopList){
                %>
                <option value="<%=objLop.getMaLop()%>"><%=objLop.getTenLop()%></option>
                <%      }
                    }
                }
                %>
            </select>
        </div>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
        <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
    </div>
</form>
  </div>
  <!-- Trong modal sửa thông tin sinh viên -->

  
 <script type="text/javascript">
  $(document).ready(function(){
	  $("form").submit(function(event){
		  event.preventDefault();
		  var formData = new FormData(this);
		  $.ajax({
			  url:"input",
			  type: "post",
			  data: formData,
			  success: function(data){
				  var row = data;
				  for(i = 0;i < row.length;i++){
					  var column = row[i];
					  var eachrow = "<tr>";
					  for(j = 0; j < column.lenght;j++){
						  eachrow = eachrow+"<td>" + column[j]+ "</td>";
					  }
					  eachrow = eachrow + "</td>";
					  $('#tbody').append(eachrow);
				  }
			  },
			  cache:false,
			  contentType: false,
			  processData: false
		  })
	  })
  }
  

</script>

<script type="text/javascript">
    function deleteStudent(maSV) {
        if (confirm("Bạn có chắc chắn muốn xóa sinh viên này không?")) {
            $.ajax({
                type: "POST",
                url: "<%=request.getContextPath()%>/sinh-vien?action=delete&masv=" + maSV,
                success: function(data) {
                    // Xử lý kết quả sau khi xóa thành công (nếu cần)
                    location.reload(); // Cập nhật lại trang sau khi xóa
                },
                error: function() {
                    alert("Đã xảy ra lỗi khi xóa sinh viên!");
                }
            });
        }
    }
    function editStudent(maSV, tenSV, diaChi, sdt, email, maLop) {
        // Điền thông tin sinh viên vào form sửa
        $("#editMaSV").val(maSV);
        $("#editTenSV").val(tenSV);
        $("#editDiaChi").val(diaChi);
        $("#editSDT").val(sdt);
        $("#editEmail").val(email);
        $("#editMaLop").val(maLop);

        // Mở modal sửa
        $("#exampleModalSua").modal("show");
    }

</script>

  <!-- /.content-wrapper -->
  <%@include file="/templates/admin/inc/footer.jsp" %>

    