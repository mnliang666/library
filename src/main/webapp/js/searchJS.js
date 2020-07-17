function search() {
    var book_name = document.getElementById("searchTxt");
    data = {};
    data["bookName"] = book_name.value;
    $.ajax({
        url: "search",
        type: "POST",
        data: data,
        dataType: "JSON",
        success: function (response) {
            console.log(response);
            $("#postTable").html("<tr style=\"font-weight: bold\"><td>书名</td><td>作者</td><td>出版社</td><td>图书余量</td><td>一键借阅</td></tr>");
            $.each(response, function (i, item) {
                let remain;
                if (item.remain !== 0) {
                    $("#postTable").append(
                        '<tr><td>' + item.title + '</td><td>' + item.author + '</td><td>' + item.publisher + '</td><td>' + item.remain + '</td><td><a class="btn btn-primary btn-xs" href="#"  role="button" id="' + item.id + '" onclick="borrowBook(this)">借阅</a></td></tr>');
                } else {
                    $("#postTable").append(
                        '<tr><td>' + item.title + '</td><td>' + item.author + '</td><td>' + item.publisher + '</td><td>' + item.remain + '</td><td><a class="btn btn-primary btn-xs" href="#" disabled="true" role="button" id="' + item.id + '">借阅</a></td></tr>'
                    );
                }
            });

        },
        error: function (xhr, msg, e) {
            alert("error!");
        }
    });
}

function borrowBook(obj) {
    const data = {};
    data["id"] = obj.id.toString();
    if (confirm("请确定是否借阅这本书？")) {
        $.ajax({
            url: "borrow",
            type: "POST",
            data: data,
            dataType: "JSON",
            success: function (response) {
                if (response === true)
                    setTimeout('window.location.href="Mybook.html"');
            },
            error: function (xhr, msg, e) {
                console.log(e);
            }
        });
        alert("借阅成功!")
    }

}