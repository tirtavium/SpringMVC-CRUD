$(function() {
	
	
	$.extend($.jgrid.defaults, {
		datatype: 'json',
		jsonReader : {
		repeatitems:false,
		
		},
		prmNames: {
		page: "page.page",
		rows: "page.size",
		sort: "page.sort",
		order: "page.sort.dir"
		},
		sortname: 'id',
		sortorder: 'asc',
		height: 'auto',
		viewrecords: true,
		rowList: [10, 20, 50, 100],
		altRows: true,
		loadError: function(xhr, status, error) {
		alert(error);
		}
		});


	$.extend($.jgrid.edit, {
	closeAfterEdit: true,
	closeAfterAdd: true,
	
	ajaxEditOptions: { contentType: "application/json" },
	mtype: 'PUT',
	serializeEditData: function(data) {
	delete data.oper;
	return JSON.stringify(data);
	}
	});
	
	$.extend($.jgrid.del, {
	mtype: 'DELETE',
	serializeDelData: function() {
	return "";
	}
	});
	

	var editOptions = {
	onclickSubmit: function(params, postdata) {
	params.url = URL + '/' + postdata.id;
	}
	};
	
	var addOptions = {
			mtype: "POST"
					
	};
	
	
	var delOptions = {
	onclickSubmit: function(params, postdata) {
	params.url = delURL + '/' + postdata;
	}
	};
	

var delURL = 'users/delete'
var URL = 'users/list';
var options = {
  url: URL,
  editurl: URL,
  colModel:[
    {
      name:'id', label: 'ID',
      formatter:'integer',
   
      width: 40,
      
      editable: true,
   //   editoptions: {disabled: true, size:5}
    },
    {
      name:'username',
      label: 'Username',
      width: 300,
      editable: true,
      editrules: {required: true}
    },
    {
        name:'password',
        label: 'password',
       
        editable: true,
     
        editrules: {required:true}
       
      },
      {
          name:'passwordConfirm',
          label: 'Password Confirm',
      
          editable: true,
         
          editrules: {required:true}
         
        },
      
    {
      name:'name',
      label: 'Name',
      width: 200,
      editable: true,
      editrules: {required: true}
    },
    {
      name:'lastName',
      label: 'Last Name',
     
      editable: true,
    
      editrules: {required:true}
     
    },
    
    {
      name:'address',
      label: 'Address',
      width: 80,
      align: 'center',
      editable: true,
      editrules: {required: true}
     
    },
    {
      name:'job',
      label: 'Job',
     
      width: 46,
      align: 'center',
      editable: true,
    
    }
  ],
  caption: "User Management",
  pager : '#pager',

  height: 'auto'
};
$("#grid")
    .jqGrid(options).navGrid('#pager',
    		{}, //options
    		editOptions,
    		addOptions,
    		delOptions,
    		{} // search options
    		);
});