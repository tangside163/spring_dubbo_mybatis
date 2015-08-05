<html>
<head>
    <meta charset="utf-8" content="text/html"/>
    <title>webix html5前端框架</title>
    <link href="${baseDir.contextPath}/js/webix/codebase/webix.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${baseDir.contextPath}/js/webix/codebase/webix.js"></script>
    <style type="text/css">
        .myaligncenter {
            margin: 0 auto;
        }

    </style>
</head>
<body>

<div id="usertable"></div>
<div id="pagingbar" style="margin: 0 auto;"></div>

<script type="text/javascript">
    webix.ui({
        container:'usertable',
        rows:[
            {
                view:'datatable',
                url:'${baseDir.contextPath}/user/getWebIXUsers',
                autoheight:true,
                resizeColumn:true,
                resizeRow:true,
                scroll:false,
                columns:[
                     {id:'name',header:'姓名',fillspace:true,sort:'server'},  //force some of columns to widen for filling the unused space
                     {id:'username',header:'用户名',fillspace:true,sort:'server'},
                     {id:'email',header:'邮箱',fillspace:true,sort:'server'},
                     {id:'phone',header:'电话',fillspace:true,sort:'server'}
                ],
                pager:{
                    template:"{common.prev()} {common.pages()} {common.next()}",
                    container:"pagingbar",
                    size:10,
                    group:5,
                    css:'myaligncenter'
                },
                on:{
                    "onBeforeSort":function(by, dir, as) {
                        alert("by = " + by + " , dir = " + dir + ", as = " + as);
                        return true;
                    },
                    onBeforeLoad:function(){
                        console.dir("Loading...");
                    },
                    "onAfterSort":function(by, dir, as) {
                        alert("排序后：by = " + by + " , dir = " + dir + ", as = " + as);
                    }
                }

            }
        ]
    });
</script>
</body>
</html>