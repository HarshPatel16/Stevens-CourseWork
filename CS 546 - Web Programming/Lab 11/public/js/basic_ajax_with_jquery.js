(function ($) {
    var showList= $('#showList').hide(),
          show = $('#show').hide(),
          searchForm=$('#searchForm'),
          search_term=$('#search_term'),
          homeLink=$('#homeLink').hide()
    
        var req = {
            method: 'GET',
            url: 'http://api.tvmaze.com/shows',
        };
    
      $.ajax(req).then(function (res) {
  
          showList.empty();
          showList.hide();
          show.hide();
          homeLink.hide();
      
          $.each(res, function () { showList.append(`<li><a class="showLink" href='${this._links.self.href}'>${this.name}</a></li>`); });
      
          showList.show();
  
          $('a.showLink').on('click', function (event) {
              event.preventDefault();
              showList.hide();
              show.empty();
              linkClicked(event.target.href);
              show.show();
              homeLink.show();
          });
      });
  
      
      searchForm.submit(function (event) {
          event.preventDefault();
  
          if (!search_term.val() || search_term.val().trim() == "") {
              alert("Atleast enter a keyword");
          }
          else {
              var req = {
                  method: 'GET',
                  url: 'http://api.tvmaze.com/search/shows?q=' + search_term.val()
              };
              $.ajax(req).then(function (res) {
                  
                homeLink.hide();
                showList.empty();
                showList.hide();
                show.hide();
                  
                $.each(res, function () { showList.append(`<li><a class="showLink" href='${this.show._links.self.href}'>${this.show.name}</a></li>`); });
                  
                showList.show();
                homeLink.show();
  
                $('a.showLink').on('click', function (event) {
                    event.preventDefault();
                    showList.hide();
                    show.empty();
                    console.log(event.target.href);
                    linkClicked(event.target.href); 
                    show.show();
                    homeLink.show();
                  });
              });
          }
      });
  
    
      function linkClicked(link) {
          var req = {
              method: 'GET',
              url: link
          };
          $.ajax(req).then(function (res) {
        
                if (res.image) { if (!res.image.medium){ res.image.medium = "/public/image/no_image.jpeg"}}
                if (!res.name || res.name.trim() == "") {res.name = "N/A"}
                if (!res.language || res.language.trim() == "") {res.language = "N/A"}
                if (res.rating){ if (!res.rating.average) { res.rating.average = "N/A"}}
                if (res.network) {if (!res.network.name || res.network.name.trim() == ""){res.network.name = "N/A"}}
                if (!res.summary || res.summary.trim() == ""){ res.summary = "N/A"}
                if (res.genres.length == 0) {res.genres = ["N/A"]}
              
                show.append(`<h1>${res.name}<h1>`)
                
                show.append(`<img src="${res.image && res.image.medium? res.image.medium: "/public/image/no_image.jpeg"}"/>`)
                
                show.append(`<dt>Language</dt>`)
                show.append(`<dd>${res.language}</dd>`)

                const genreList = $('<ul></ul>');
                res.genres.forEach((genre)=>{genreList.append(`<li>${genre}</li>`)});
                
                show.append(`<dt>Genres</dt>`)
                show.append(genreList)
                
                show.append(`<dt>Average Rating</dt>`)
                show.append(`<dd>${res.rating.average}</dd>`)      
                
                show.append(`<dt>Network</dt>`)
                show.append(`<dd>${res.network && res.network.name? res.network.name: "N/A"} </dd>`)
                
                show.append(`<dt>Summary</dt>`)
                show.append(`<dd>${res.summary}</dd>`)
          });
      }
  })(window.jQuery);