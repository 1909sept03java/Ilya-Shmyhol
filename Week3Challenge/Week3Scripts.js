/*window.onload=function(){
    document.getElementById("user").onclick=function(){
        const apiUrl= "https://randomuser.me/documentation";
        const ul=document.getElementById('users')
        sendAjaxGet(url, getUser);
    }
}
function createNode(element) {
    return document.createElement(element);
}
function append(parent, el) {
    return parent.appendChild(el);
}
function sendAjaxGet(url,func){
    let xhr= new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if(this.readyState===4 &&this.status===200){
            func(this);
        }
    }


}
xhr.open("GET",url,true);
xhr.send();
*/
window.onload=function(){
    document.getElementById("user").onclick=function(){
    function createNode(element) {
    return document.createElement(element);
}

function append(parent, el) {
    return parent.appendChild(el);
}

const ul=document.getElementById('users');

const apiUrl= 'https://randomuser.me/api/?results=25';
fetch(apiUrl)
    .then((resp) => resp.json())
    .then(function(data){
        let users=data.results;
        return users.map(function(user){
            let li=createNode('li'),
                img=createNode('img'),
                span=createNode('span');
            img.src=user.picture.medium;
            span.innerHTML= "Name: "+`${user.name.first} ${user.name.last}`+"Age"+ `${user.dob.age}`;
            append(li,img);
            append(li, span);
            append(ul, li);
        })
    
    })
    .catch((error)=>{
        alert('oh no');
        console.log(error);
    });

