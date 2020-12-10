//----HOME----
const Home = {
    template: "#home",
    name: 'Home',
    data: ()=> {
        return {

        }
    },
    methods: {
    },
    mounted() {
    
    }
};

//----CONNEXION----
const Signin = {
    template: "#signin",
    name: 'Signin',
    data: ()=> {
        return {
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
        }
    },
    methods: {
        
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
