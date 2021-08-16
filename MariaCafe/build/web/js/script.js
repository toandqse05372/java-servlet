/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function KeepHightlight() {
    var list = document.getElementById("menuBar").getElementsByTagName("a");
    var defaultPage = "http://localhost:8080/LAB_MariaCafe/";
    var detail = "http://localhost:8080/LAB_MariaCafe/CakeDetail.jsp";
    var productList = "http://localhost:8080/LAB_MariaCafe/Cakes.jsp";
    var n1 = (window.location.href.toString()).includes(detail);
    var n2 = (window.location.href.toString()).includes(productList);
    for (var i = 0; i < list.length; i++) {
        if (window.location.href === defaultPage) {
            list[0].style.fontWeight = "Bold";
            list[0].style.fontSize = "100%";
        }
        if (n1 || n2) {
            list[1].style.fontWeight = "Bold";
            list[1].style.fontSize = "100%";
        }   
        if (list[i].href === window.location.href) {
            list[i].style.fontWeight = "Bold";
            list[i].style.fontSize = "100%";
        }
    }
}

function DisabledLink() {
    var list = document.getElementById("page").getElementsByTagName("a");
    var productList = "http://localhost:8080/LAB_MariaCafe/Cakes.jsp";
    for (var i = 0; i < list.length; i++) {
        if (window.location.href === productList) {
            list[0].style.color = "gray";
            list[0].style.pointerEvents = "none";
            list[0].style.border = "none";
        }
        if (list[i].href === window.location.href) {
            list[i].style.color = "gray";
            list[i].style.pointerEvents = "none";
            list[i].style.border = "none";
        }
    }
}


