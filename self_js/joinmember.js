// DOM (Document Object Model)
// 자바스크림에서 html을 컨트롤 하기위해서 사용되는
// DOM
const toggleBtn=document.querySelector('.navbar_togleBtn');
const menu=document.querySelector('.navbar_menu');
const icons=document.querySelector('.navbar_icons');

toggleBtn.addEventListener('click' , () => {
    icons.classList.toggle('active');
    menu.classList.toggle('active');
});
// 토클링 껏다켰다
// toggle