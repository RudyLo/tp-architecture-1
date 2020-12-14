//---STORE---
const store = new Vuex.Store({
    token: "",
    mutations: {
        getCookie() {
            if($cookies.get('token')){
                cookie = JSON.parse($cookies.get('token'));
                console.log("store | getcookie() | valeur token | " + cookie);
                store.token = cookie;
                return cookie;
            }else{
                console.log("il n'y a pas de cookie token");
            }
        },
    }
})


//----HOME----
const Home = {
    template: "#home",
    name: 'Home',
    data: ()=> {
        return {
            username: "",
            pseudo: "",
            email: "",
            cookie: "",
            tab:[],
            vol: {
                id: "",
                user: "",
                codeDepart: "",
                codeArrivee: "",
                dateVol: "",
                prixVol: "",
            },
        }
    },
    methods: {
        getUser() {
            if (store.token == "" || store.token == "null"){
                console.log("aucun token");
            }else{
                console.log('Bearer ' + store.token);
                fetch("http://localhost:8080/user", {
                method: 'GET',
                headers: {
                    'Authorization': 'Bearer ' + store.token,
                }})
            .then( response => {
                response.json().then(data => {
                console.log(data);
                //this.id = data.id;
                this.username = data.username;
                this.pseudo = data.name;
                this.mail = data.email;
                })})
            }
        },

        getVols(){
            fetch("http://localhost:8080/reservation/all", {
                method: 'GET',
                headers: {
                    'Authorization': 'Bearer ' + store.token,
                }})
            .then( response => {
                response.json().then(data => {
                console.log(data);
                this.vols = data;
                console.log(data);
                data.forEach(element => {
                    var obj = new Object();
                    obj.id = element.id;
                    obj.user = element.user;
                    obj.date = element.dateVol;
                    obj.depart = element.codeDepart;
                    obj.arrive = element.codeArrivee;
                    obj.prix = element.prixVol;
                    console.log(obj);
                    this.tab.push(obj);
                });
                console.log(this.vols);
                console.log(this.tab);
                })})
        }
    },
    mounted() {
        store.commit('getCookie');
        console.log("home | fin mounted | valeur token store | " + store.token);
        this.cookie = store.token;
        this.getUser();
        this.getVols();
        
    }
};

//----CONNEXION----
const Signin = {
    template: "#signin",
    name: 'Signin',
    data: ()=> {
        return {
            
        }
    },
    methods: {
        Connexion: async() => {
            var username = document.getElementById("username-login").value;
            var password = document.getElementById("password-login").value;
            console.log("username : " + username + "\npassword : " + password);
      
            const rawResponse = await fetch('http://localhost:8080/user/authentification', {
              method: 'POST',
              headers: {
                'Content-Type': 'application/json'
              },
            body: JSON.stringify({username: username, password: password})
            });
            const content = await rawResponse.json();
            console.log(content.token);
                if (content.token == "" || content.token == null || content.token == undefined ){
                    console.log("identifiants incorrectes")
                }else{
                    $cookies.set('token', JSON.stringify(content.token));
                    router.push({ path: '/'});
                }
            },
    },
    mounted() {
    
    }
};

//----INSCRIPTION----
const Signup = {
    template: "#signup",
    name: 'Signup',
    data: ()=> {
        return {

        }
    },
    methods: {
        Inscription: async() => {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var pseudo = document.getElementById("pseudo").value;
            var mail = document.getElementById("mail").value;
            console.log("username : " + username + "\npassword : " + password + "\npseudo : " + pseudo + '\nmail : ' + mail);
      
            const rawResponse = await fetch('http://localhost:8080/user/registration', {
              method: 'POST',
              headers: {
                'Content-Type': 'application/json'
              },
            body: JSON.stringify({username: username, password: password, name: pseudo, email: mail})
            });
            const content = await rawResponse.json();
            console.log(content);
            },
    },
    mounted() {
    
    }
};

//----VOL----
const Vol = {
    template: "#vol",
    name: 'Vol',
    data: ()=> {
        return {

        }
    },
    methods: {
    },
    mounted() {
        
    }
};




//----ROUTER----
const router = new VueRouter({
    routes: [
        { path: '/', component: Home, name: 'Home' },
        { path: '/sign-up', component: Signup, name: 'Signup' },
        { path: '/sign-in', component: Signin, name: 'Signin' },
        { path: '/vol', component: Vol, name: 'vol' },
    ]
});

const vue = new Vue({
    router
}).$mount("#app");
