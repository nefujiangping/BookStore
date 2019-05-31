<template>
  <div class="Header">
  	<router-link :to="{name:'index_page'}">
  		<img src="../assets/logo.jpg"/>
  	</router-link>
	<span id="span_logout" v-if="this.$store.state.ifLogin">
		<a id="a_logout" href="#" v-on:click="logout">退出</a>
	</span>
	<span id="span_username" v-if="this.$store.state.ifLogin">
		<router-link :to="{ name: 'user_info_page', params: { username: this.$store.state.username }}" :title="this.$store.state.displayName">
			{{this.$store.state.displayName}}
		</router-link>
	</span>
  </div>
</template>

<script>
export default {
  name: 'Header',
  data () {
    return {
    }
  },
  methods: {
  	logout (){
		if(confirm(`退出登陆购物车将被清空,是否退出？`)){
			this.$store.dispatch('clearAll');
			this.$router.replace({path: '/login'});
			return true;
		} else {
			return false;
		}
	}
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
	.Header {
		background:#ddd;
		height: 75px;
	}
	/* a {
		text-decoration: none;
		color: #cbc9c9;
	} */
	img {
		max-width: 120px;
		margin-left: 50px;
		margin-top: 5px;
	}
	#span_username {
		float: right;
		margin-right: 15px;
		margin-top: 15px;
		font: "microsoft yahei" bold;
		font-size: 23pt;
	}
	#span_logout {
		float: right;
		margin-right: 15px;
		margin-top: 30px;
	}
	
</style>
