$(document).ready(function(){
          $("button").click(function(){
            $.ajax({
                    url: '/bin/submitdata3',
                    method: 'POST',
                    data: {},
                    cache: false,
                    mimeType: 'text/html',
                    success: function (data) {
                  window.location.href="/content/mywebsite/us/en/newform.html";
                    },
                    error: function (xhr, status, err) {
                         window.location.href="/content/mywebsite/us/en/Success.html";
                    }
                });
          });
        });