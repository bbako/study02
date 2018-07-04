
<%@ include file="/WEB-INF/views/include/header.jsp" %>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">Dashboard</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Dashboard v2</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <section class="content">
    
    	<table class="table table-bordered">
    		<tr>
    			<th> bno</th>
    			<th>title</th>
    			<th>content</th>
    			<th>writer</th>
    			<th>regdate</th>
    			<th>viewcnt</th>
    		</tr>
    		
    		<tr>
    			<th>${one.bno}</th>
    			<th>${one.title}</th>
    			<th>${one.content}</th>
    			<th>${one.writer}</th>
    			<th>${one.regdate}</th>
    			<th>${one.viewcnt}</th>
    		</tr>
    		
    		
    	</table>
    
		<form id="f1" method="post">
			<input type="hidden" name="bno" value="${one.bno}">
		</form>    
    
    <button id="modify" type="submit">modify</button>
    <button id="remove" type="submit">remove</button>
    <button id="list" type="submit">list All</button>
    
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
 
<%@ include file="/WEB-INF/views/include/footer.jsp" %>

<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Morris.js charts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="plugins/morris/morris.min.js"></script>
<!-- Sparkline -->
<script src="plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="plugins/knob/jquery.knob.js"></script>
<!-- daterangepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
<script src="plugins/daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js">
</script>
<script type="text/javascript">
	$(document).ready(function() {
		
		console.log("gogo???")
		
		var formObj = $("#f1");
		
		$("#modify").on("click", function() {
			
			console.log("click???")
			
			formObj.attr("action","/board/modify")
			formObj.attr("method","get")
			formObj.submit();
			
		})
		
	})
		
	

</script>
</body>
</html>
