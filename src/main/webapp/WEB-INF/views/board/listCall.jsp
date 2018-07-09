<%@ include file="/WEB-INF/views/include/header.jsp" %>
<div class="wrapper">

  <!-- Main Sidebar Container -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Data Tables</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Data Tables</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-12">
          <div class="card">
            <div class="card-header">
              <h3 class="card-title">Hover Data Table</h3>
            </div>
            <!-- /.card-header -->
            <div class="card-body">
                
                <p id="total"></p> 
              <table class="table table-hover table-condensed table-striped">
				<thead>
					<tr>
						<th class="text-center">No</th>
						<th class="text-center">Title</th>
						<th class="text-center">content</th>
						<th class="text-center">Writer</th>
						<th class="text-center">Date</th>
						<th class="text-center">Views</th>
					</tr>
				</thead>
				<tbody id="showlist">
					
				</tbody>
			</table>
              <div>
				<ul class="pagination">
				
				</ul>
			</div>
            </div>
            <!-- /.card-body -->
          </div>
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <div class="float-right d-none d-sm-block">
      <b>Version</b> 3.0.0-alpha
    </div>
    <strong>Copyright &copy; 2014-2018 <a href="http://adminlte.io">AdminLTE.io</a>.</strong> All rights
    reserved.
  </footer>
</div>
<script>
$(document).ready(function(e) {
	var page = 1;
	var key = "";
	
	function makeTable(list){
		 
		 var str="";
		 
		 $.each(list, function(index, value) {
			 
			 str+='<tr><td class="text-center"><a>'+value.bno+'</a></td>'
			 		+'<td class="text-center">'+value.title+'</td>'
			 		+'<td class="text-center">'+value.content+'</td>'
					+'<td class="text-center">'+value.writer+'</td>'
					+'<td class="text-center">'+value.regdate+'</td>'
					+'<td class="text-center">'+value.viewcnt+'</td></tr>'
					
			}); 
		 
		 	$("#showlist").html(str);
		 	
	}
	
	init_list(page);
	
	function init_list(page){
		
		$.ajax({
			  type: "POST",
	    	  url: "/board/listCall",
	    	  dataType: 'json',	 	
	    	  data : {
	 			 	
		        	page : page,
		  
		        	
		        },
		        
	    	  success: function(re){
	    		
	    		makeTable(re.list);
	    		printPageing(re.total);
	    	  } 
	         
		 });
	}
	
	
	function printPageing(total){
		
		var totalStr = "total = " + total;
	
		$("#total").html(totalStr);
		
		var str = "";
		
		var prev = Math.floor((page-1)/10) > 0 ? true : false ;
		var start = Math.floor((page-1)/10)*10+1;
		var end0 = Math.ceil(page/10)*10;
		var end = end0 > total ? total : end0;
		var next = end < total/20 ? true : false;
		
		if(prev){
			 
			 str +="<li ><a href='"+(start-1)+"'> << </a></li>";
			 
		 } 
		
 		for(var i=start;  i <= end; i++){
			
			 var bold = page == i?"class='active'":'';
			
 			str += "<li "+bold+"><a href = '"+i+"'>"+i+"&nbsp"+"</a></li>"; 
		}
		
		 if(next){
			
			str +="<li ><a href='"+(end+1)+"'> >> </a></li>";
		} 
		
		$(".pagination").html(str); 
		
	}
	
	$(".pagination").on("click","a",function(e){
		
		e.preventDefault();
		
		page = $(this).attr('href');
		
		init_list(page);
		
	})
})
</script>
</body>
</html>
