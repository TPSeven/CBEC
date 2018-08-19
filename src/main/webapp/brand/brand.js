
/*品牌管理*/
$(document).ready(function () {
			//显示员工列表
            $("table#BrandGrid").jqGrid({
            	//指定数据来源
                url: 'brand/list/condition/page.mvc',
                mtype: "GET",
				styleUI : 'Bootstrap',
                datatype: "json",
                colModel: [
                    { label: '品牌商ID', name: 'brand_id', key: true, width: 200 },
                    { label: '品牌商名字', name: 'brand_name', width: 200},
                    { label: '制造商ID', name: 'manufacturer.id', width: 200 },
                    { label: '品牌商描述', name: 'brand_desc', width: 200 },
                    { label:'品牌商注册时间', name: 'brand_time', width: 200 }
                ],
                //是否显示记录
                autowidth:ture,
				viewrecords: true,
				height: 250,
				width: "100%",
				//一行显示多少个
                rowNum: 20,
                pager: "#BrandGridPager"
            });
        });