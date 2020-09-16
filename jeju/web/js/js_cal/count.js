var sell_price;
var amount;
var sell_price2;
var amount2;


function init () {
	sell_price = document.form.sell_price.value;
	amount = document.form.amount.value;
	document.form.sum.value = sell_price;
	change();
	
	sell_price2 = document.form.sell_price2.value;
	amount2 = document.form.amount2.value;
	document.form.sum2.value = sell_price2;
	change2();
}

function add () {
	hm = document.form.amount;
	sum = document.form.sum;
	hm.value ++ ;

	sum.value = parseInt(hm.value) * sell_price;
}


function del () {
	hm = document.form.amount;
	sum = document.form.sum;
		if (hm.value > 1) {
			hm.value -- ;
			sum.value = parseInt(hm.value) * sell_price;
		}
}

function add2 () {
	hm2 = document.form.amount2;
	sum2 = document.form.sum2;
	hm2.value ++ ;

	sum2.value = parseInt(hm2.value) * sell_price2;
}


function del2 () {
	hm2 = document.form.amount2;
	sum2 = document.form.sum2;
	
		if (hm2.value > 1) {
			hm2.value -- ;
			sum2.value = parseInt(hm2.value) * sell_price2;
		}
}

function change () {
	hm = document.form.amount;
	sum = document.form.sum;
	
		if (hm.value < 0) {
			hm.value = 0;
		}
		
	sum.value = parseInt(hm.value) * sell_price
	
}  

function change2 () {
	
	hm2 = document.form.amount2;
	sum2 = document.form.sum2;

		if (hm2.value < 0) {
			hm2.value = 0;
		}
		
	sum2.value = parseInt(hm2.value) * sell_price2
	
	
}  




/*function change3(){
	
	total = (parseInt(hm.value) * sell_price)+(parseInt(hm2.value) * sell_price2)
	sum3.value =total;
	
	
}*/


