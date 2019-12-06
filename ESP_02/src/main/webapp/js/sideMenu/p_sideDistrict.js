
             
              $(document).ready(function(){
            	  
            	  
            	  

            	  if(disSideSlideSW == 1){
            		  
            		  
            		  var submenu = $(".columnSideDistrictDrop");
            		  
            		  submenu.slideDown();
            		  
            		  
            		  
            	  }
            	  
            	  
            	  
            	  
            	  
            	  
                 
                  $(".columnSideDistrictMenu").click(function(){
                      var submenu = $(this).next("div");
           
                     
                      if( submenu.is(":visible") ){
                          submenu.slideUp();
                      }else{
                          submenu.slideDown();
                      }
                  });


                  $(".columnSideProvinceMenu").click(function(){
                      var submenu = $(this).next("div");
           
                     
                      if( submenu.is(":visible") ){
                          submenu.slideUp();
                      }else{
                          submenu.slideDown();
                      }
                  });


              });
       