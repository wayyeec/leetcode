function getIndex(){
    $.ajax({
        type:'get',
        url:'/index',
        dataType:'html',
        contentType:'application/json; charset=utf-8',
        success:function (data) {
            $('#app').html(data);
        },
        error:function () {
        }
    });
}
function getCategories(){
    $.ajax({
        type:'get',
        url:'/categories',
        dataType:'html',
        contentType:'application/json; charset=utf-8',
        success:function (data) {
            $('#app').html(data);
        },
        error:function () {
        }
    });
}
function getArchives(){
    $.ajax({
        type:'get',
        url:'/archives',
        dataType:'html',
        contentType:'application/json; charset=utf-8',
        success:function (data) {
            $('#app').html(data);
        },
        error:function () {
        }
    });
}
function getTags(){
    $.ajax({
        type:'get',
        url:'/tags',
        dataType:'html',
        contentType:'application/json; charset=utf-8',
        success:function (data) {
            $('#app').html(data);
        },
        error:function () {
        }
    });
}
function getUpdate(){
    $.ajax({
        type:'get',
        url:'/update',
        dataType:'html',
        contentType:'application/json; charset=utf-8',
        success:function (data) {
            $('#app').html(data);
        },
        error:function () {
        }
    });
}
function getFridentLink(){
    $.ajax({
        type:'get',
        url:'/friendlylink',
        dataType:'html',
        contentType:'application/json; charset=utf-8',
        success:function (data) {
            $('#app').html(data);
        },
        error:function () {
        }
    });
}
function getMe(){
    $.ajax({
        type:'get',
        url:'/aboutme',
        dataType:'html',
        contentType:'application/json; charset=utf-8',
        success:function (data) {
            $('#app').html(data);
        },
        error:function () {
        }
    });
}
function login(){
    $.ajax({
        type:'get',
        url:'/loginVal',
        dataType:'html',
        contentType:'application/json; charset=utf-8',
        success:function (data) {
            $('#app').html(data);
        },
        error:function () {
        }
    });
}
function getUser(){
    $.ajax({
        type:'get',
        url:'/user',
        dataType:'html',
        contentType:'application/json; charset=utf-8',
        success:function (data) {
            $('#app').html(data);
        },
        error:function () {
        }
    });
}
function getSuperadmin(){
    $.ajax({
        type:'get',
        url:'/superadmin',
        dataType:'html',
        contentType:'application/json; charset=utf-8',
        success:function (data) {
            $('#app').html(data);
        },
        error:function () {
        }
    });
}
function register(){
    $.ajax({
        type:'get',
        url:'/register',
        dataType:'html',
        contentType:'application/json; charset=utf-8',
        success:function (data) {
            $('#app').html(data);
        },
        error:function () {
        }
    });
}
/*function mdeditor(){
    $.ajax({
        type:'get',
        url:'/editor',
        dataType:'html',
        contentType:'application/json; charset=utf-8',
        success:function (data) {
            $('#app').html(data);
        },
        error:function () {
        }
    });
}*/
