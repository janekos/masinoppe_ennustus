"use strict";

class app{
	constructor(){
		this.api = "http://localhost:4568/api/";
		this.ajax("listModels", "GET", this.populateModels);
		this.bindEvents();
	}
	
	populateModels(arr){
		let models = document.getElementById("models");
		arr = arr.split(",");
		for(let i = 0; i < arr.length; i++){
			arr[i] = arr[i].replace(" ", "");
			arr[i] = arr[i].replace("[", "");
			arr[i] = arr[i].replace("]", "");
			let option = document.createElement("option");
			option.text = arr[i];
			models.add(option);
		}
		//console.log(arr);
	}
	
	bindEvents(){
		this.grab("tf").addEventListener("change",(e)=>{
			this.ajax("config/tf/" + e.target.checked, "GET", ()=>{});
		});
		this.grab("idf").addEventListener("change",(e)=>{
			this.ajax("config/idf/" + e.target.checked, "GET", ()=>{});
		});
		this.grab("models").addEventListener("change",(e)=>{
			let value = e.target.options[e.target.selectedIndex].value
			this.ajax("config/activeModel/" + value, "GET", ()=>{});
		});
		this.grab("submit").addEventListener("click",(e)=>{
			let text = this.grab("inputTA").value;
			//console.log(text);
			this.ajax("predict/"+text, "GET", (text) => {this.grab("output").innerHTML = text;});
		});
	}
	
	ajax(path, type, callback){
		return new Promise((resolve, reject) => {
			const xhr = new XMLHttpRequest();
			xhr.open(type, this.api + path);
			//if(type == "GET"){
			xhr.onload = () => resolve(callback(xhr.responseText));
			/*}else if(type == "PUT"){
				//xhr.setRequestHeader('Content-Type', 'text/html');
				xhr.onload = () => resolve(console.log(xhr.responseText));
			}*/			
			xhr.onerror = () => reject(xhr.statusText);
			xhr.send();
		});
	}
	
	grab(id){
		return document.getElementById(id);
	}
}

new app();