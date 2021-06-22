<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"></link>
    <style type="text/css">
        body {
            font-family: 'Microsoft YaHei';
        }
        @page {
            size: A4;
        }
        .pdf {
            max-width: 80px!important;
        }
        .container {
            margin-left: 0;

        }
    </style>
</head>
<body class="pdf">
<div class="container pdf">

</div>
<h1 class="pdf">根据 FreeMarker 模板导出 PDF 文件（基于 Spring Boot）</h1>
<h2 class="pdf">作者：${author}</h2>
<hr></hr>
<h3 class="pdf">test 测试换行12测试换行</h3>
<p class="pdf">
    <img src="https://avatar.csdn.net/6/1/D/3_sai_simon.jpg"></img>
    <br></br>

        <a href="${url}">文章地址${url}</a>
        <p>负责人签名：name-${author} </p>

</p>
<div class="pdf">空&nbsp;格</div>
<img style="width: 200px;" src="${imgUrl}"/>
</body>
</html>