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
