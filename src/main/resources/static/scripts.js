var form_1 = document.querySelector(".form_1");
var form_2 = document.querySelector(".form_2");
var form_3 = document.querySelector(".form_3");

var form_1_btns = document.querySelector(".form_1_btns");
var form_2_btns = document.querySelector(".form_2_btns");
var form_3_btns = document.querySelector(".form_3_btns");

var form_1_next_btn = document.querySelector(".form_1_btns .btn_next");
var form_2_back_btn = document.querySelector(".form_2_btns .btn_back");
var form_2_next_btn = document.querySelector(".form_2_btns .btn_next");
var form_3_back_btn = document.querySelector(".form_3_btns .btn_back");

var form_1_progessbar = document.querySelector(".form_1_progessbar");
var form_2_progessbar = document.querySelector(".form_2_progessbar");
var form_3_progessbar = document.querySelector(".form_3_progessbar");

var form_1 = document.querySelector(".form_1");

var form_2 = document.querySelector(".form_2");
var form_3 = document.querySelector(".form_3");

var btn_done = document.querySelector(".btn_done");
var modal_wrapper = document.querySelector(".modal_wrapper");
var shadow = document.querySelector(".shadow");
var success_wrap = document.querySelector(".success_wrap");

// Function to update progress bars
function updateProgressBars(currentIndex) {
    // Select all progress bar items
    const progressBarItems = document.querySelectorAll('.header ul li');

    // Loop through all progress bar items
    progressBarItems.forEach((item, index) => {
        // Check if the index is less than or equal to the current index
        if (index <= currentIndex) {
            // Update the content of the div with a check mark icon
            item.querySelector('div').innerHTML = '<p><i class="fas fa-check"></i></p>';
        }
    });
}

// In form1.html
var form_1_next_btn = document.querySelector(".form_1_btns .btn_next");
var form_2_progessbar = document.querySelector(".form_2_progessbar");

form_1_next_btn.addEventListener("click", function(){
//    form_1.style.display = "none";
//    form_2.style.display = "block";
//
//    form_1_btns.style.display = "none";
//    form_2_btns.style.display = "flex";

//  form_2_progessbar.classList.add("active");

    updateProgressBars(1); // Update progress bar when form 1 is completed
});

// In form2.html
var form_2_back_btn = document.querySelector(".form_2_btns .btn_back");
var form_2_next_btn = document.querySelector(".form_2_btns .btn_next");
var form_3_progessbar = document.querySelector(".form_3_progessbar");

form_2_back_btn.addEventListener("click", function(){
    form_1.style.display = "block";
    form_2.style.display = "none";

    form_1_btns.style.display = "flex";
    form_2_btns.style.display = "none";

    form_2_progessbar.classList.remove("active");

    updateProgressBars(0); // Update progress bar when going back from form 2 to form 1
});

form_2_next_btn.addEventListener("click", function(){
    form_2.style.display = "none";
    form_3.style.display = "block";

    form_3_btns.style.display = "flex";
    form_2_btns.style.display = "none";

    form_3_progessbar.classList.add("active");

    updateProgressBars(2); // Update progress bar when form 2 is completed
});

// In form3.html
var form_3_back_btn = document.querySelector(".form_3_btns .btn_back");

form_3_back_btn.addEventListener("click", function(){
    form_2.style.display = "block";
    form_3.style.display = "none";

    form_3_btns.style.display = "none";
    form_2_btns.style.display = "flex";

    form_3_progessbar.classList.remove("active");

    updateProgressBars(1); // Update progress bar when going back from form 3 to form 2
});

btn_done.addEventListener("click", function(){
    modal_wrapper.classList.add("active");
    form_3_progessbar.innerHTML = '<div><p><i class="fas fa-check"></i></p></div>';
    success_wrap.innerHTML = '<span class="modal_icon"><div><p><i class="fas fa-check"></i></p></div></span><p>You have successfully completed the process.</p>';
});

shadow.addEventListener("click", function(){
    modal_wrapper.classList.remove("active");
});
