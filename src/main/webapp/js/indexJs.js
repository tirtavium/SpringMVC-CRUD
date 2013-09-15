$(function() {
	
	
	$.extend($.jgrid.defaults, {
		datatype: 'json',
		jsonReader : {
		repeatitems:false,
		total: function(result) {
		//Total number of pages
		return Math.ceil(result.total / result.max);
		},
		records: function(result) {
		//Total number of records
		return result.total;
		}
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
      editoptions: {disabled: true, size:5}
    },
    {
      name:'username',
      label: 'Username',
      width: 300,
      editable: true,
      editrules: {required: true}
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
      hidden: true,
      editable: true,
      edittype: 'select',
      editrules: {required:true}
     
    },
    {
      name:'address',
      label: 'aAddress',
      width: 80,
      align: 'center',
      editable: true,
      editrules: {required: true}
     
    },
    {
      name:'job',
      label: 'Available',
      formatter: 'checkbox',
      width: 46,
      align: 'center',
      editable: true,
      edittype: 'checkbox',
      editoptions: {value:"true:false"}
    }
  ],
  caption: "job",
 
  height: 'auto'
};
$("#grid")
    .jqGrid(options);
});