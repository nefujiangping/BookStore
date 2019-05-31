<template>
	<div class="log">
		<div id="login_modal" class="modal" data-backdrop="static" aria-hidden="false" align="center">
			<div class="modal-dialog">
				<div class="modal-content" align="center">
					<div class="modal-header" align="center">
						<h4 class="modal-title">登录</h4>
					</div>
					<div class="modal-body" style="padding-top:0;padding-bottom: 0;">
						<form class="form-horizontal">
							<div class="form-group">
								<div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12" style="display: inline-block;">
									<div id="the-email">
										<input type="text" v-model="loginInfoVo.username" class="form-control typeahead action-login input-lg" id="login_email" placeholder="邮箱"
										 autocomplete="on">
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12" style="display: inline-block;">
									<input type="password" v-model="loginInfoVo.password" 
									class="form-control action-login input-lg" 
									id="login_password" placeholder="密码"
									v-on:keyup.enter="login">
								</div>
							</div>
							<div class="form-group">
								<div class="col-lg-offset-1 col-lg-10 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12">
									<button type="button" v-on:click="login" id="login_confirm" class="btn btn-primary" data-loading-text="登录中...">
										登录
									</button>
								</div>
							</div>
							<div class="form-group" style="padding-top: 10px; padding-bottom: 30px; text-align: center;">
								<div class="col-lg-offset-1 col-lg-10 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12">
									<p>
										<a href="#" v-on:click="gotoRegister">没有账号？点此注册</a>
									</p>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		
		<div id="reg_modal" class="modal" data-backdrop="static" aria-hidden="false">
			<div class="modal-dialog">
				<div class="modal-content" align="center">
					<div class="modal-header">
						<h4 class="modal-title">注册</h4>
					</div>
					<div class="modal-body" style="padding-top:0;">
						<form class="form-horizontal">
							<div class="form-group" id="groupemail">
								<div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12">
									<div id="the-email-reg">
										<input type="text" v-model="registerInfoVo.username" class="form-control typeahead action-reg input-lg" id="reg_email" placeholder="邮箱"
										 autocomplete="on">
									</div>
								</div>
							</div>
							<div class="form-group" id="groupemail">
								<div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12">
									<div id="the-displayName-reg">
										<input type="text" v-model="registerInfoVo.displayName" 
										class="form-control typeahead action-reg input-lg"  
										placeholder="昵称" autocomplete="on">
									</div>
								</div>
							</div>
							<div class="form-group" id="grouppassword">
								<div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12">
									<input type="password" v-model="registerInfoVo.password1" class="form-control typeahead action-reg input-lg" id="reg_password" placeholder="密码">
								</div>
							</div>
							<div class="form-group">
								<div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12">
									<input type="password" v-model="registerInfoVo.password2" class="form-control typeahead action-reg input-lg" id="reg_password_again" placeholder="再次输入密码">
								</div>
							</div>
							<div class="form-group">
								<div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12">
									<button type="button" v-on:click="register" id="reg_confirm" class="btn btn-primary" data-loading-text="注册中...">
										注册
									</button>
								</div>
							</div>

							<div class="form-group" style="padding-top: 10px; padding-bottom: 30px; text-align: center;">
								<div class="col-lg-offset-1 col-lg-10 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12">
									<p>
										<a href="#" v-on:click="gotoLogin">已有账号，直接登录</a>
									</p>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>


<script>
/*==============导入一些js组件==================*/
	import toastr from '../assets/js/toastr.min.js'
		
/*====================一些登陆/注册的函数================*/
/**
 * 检查Email是否合法
 * @param  email
 * @returns  {boolean}
 */
function checkEmail(email) {
	if (email == '' || email == null || email == 'undefined') {
		return false;
	}
	var mailReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	if (!mailReg.test(email)) {
		return false;
	}
	return true;
}
/**
 * 检查注册时密码是否合法
 * @param passwd
 * @returns  {boolean}
 */
function registerCheckPassword(passwd, repasswd) {
	if (passwd == '' || passwd == null || passwd == 'undefined') {
		return false;
	}
	if (repasswd == '' || repasswd == null || repasswd == 'undefined') {
		return false;
	}
	if (repasswd.length < 4) {
		return false;
	}
	if (passwd != repasswd) {
		return false;
	}
	return true;
}
/**
 * 检查登陆密码是否合法
 * @param
 * @returns  {boolean}
 */
function loginCheckPassword(passwd) {
	if (passwd == '' || passwd == null || passwd == 'undefined') {
		return false;
	}
	if (passwd.length < 4) {
		return false;
	}
	return true;
}
/*==============一些初始化工作=========================*/

$(function(){
	toastr.options = {
		positionClass: 'toast-top-center',
		showDuration: "100",
		target: '.log'
	}
})

/*=================vue.js==========================*/	
	export default {
		name: 'Login',
		data(){
			return {
				loginInfoVo:{
					username: '',
					password: ''
				},
				registerInfoVo:{
					username: '',
					password1: '',
					password2: '',
					displayName: ''
				}
			}
		},
		methods: {
			// 设置登录状态和用户名
			setVuex(iflogin, username, displayName) {
			  this.$store.dispatch('setIfLogin', iflogin);
			  this.$store.dispatch('setUsername', username);
			  this.$store.dispatch('setDisplayName', displayName);
			},
			gotoRegister() {
				console.log('gotoRegister');
				$('#reg_modal').css('display', 'block');
				$('#login_modal').css('display', 'none');
			},
			gotoLogin() {
				console.log('gotoLogin');
				$('#login_modal').css('display', 'block');
				$('#reg_modal').css('display', 'none');
			},
			login(){
				// login
				// console.log(checkEmail(this.loginInfoVo.username));
				// console.log(this.MD5.hex_md5('tesT!@#'));
				if(!checkEmail(this.loginInfoVo.username)){
					toastr.error('邮箱格式错误！');
					$('#login_email').focus();
					return false;
				}
				if(!loginCheckPassword(this.loginInfoVo.password)){
					toastr.error('密码长度必须大于四位！');
					$('#login_password').focus();
					return false;
				}				
				this.$http
					.post('/login', {
					  username: this.loginInfoVo.username,
					  // should be encoded
					  password: this.MD5.hex_md5(this.loginInfoVo.password)
					})
					.then(successResponse => {
					  this.responseResult = JSON.stringify(successResponse.data)
					  if (successResponse.data.code != 0) {  // Error
						toastr.error(successResponse.data.message);
					  } else {                             // Success
						toastr.success(successResponse.data.message);
						this.setVuex(true, successResponse.data.object.userId, successResponse.data.object.displayName);  // id,displayName
						this.$router.replace({path: '/'});
					  } 
					})
					.catch(failResponse => {
						console.log('Login Failed!');
					});
			},
			register(){
				// register
				// console.log(checkEmail(this.loginInfoVo.username));
				if(!checkEmail(this.registerInfoVo.username)){
					toastr.error('邮箱格式错误！');
					$('#reg_email').focus();
					return false;
				}
				if(!registerCheckPassword(this.registerInfoVo.password1, this.registerInfoVo.password2)){
					toastr.error('密码长度小于四位或者两次输入不同！');
					$('#reg_password').focus();
					return false;
				}
				this.$http
					.post('/register', {
					  username: this.registerInfoVo.username,
					  password: this.MD5.hex_md5(this.registerInfoVo.password1),
					  displayName: this.registerInfoVo.displayName
					})
					.then(successResponse => {
					  this.responseResult = JSON.stringify(successResponse.data)
					  if (successResponse.data.code === 0) {  // Success
						// this.$router.replace({path: '/index'})
						console.log(successResponse.data);
						toastr.success(successResponse.data.message);
						this.setVuex(true, successResponse.data.object.userId, successResponse.data.object.displayName);  // id,displayName
						this.$router.replace({path: '/'});
					  } else {  // Error
						toastr.error(successResponse.data.message); 
						$("#reg_email").focus();
					  }
					})
					.catch(failResponse => {
						console.log('Register Failed!');
					});
			},
		}
	}
</script>

<style>
	@import url("../assets/css/login.css");
	@import url("../assets/css/toastr.css");
	
	#login_modal{
		display: block;
	}
	.modal-content{
		top: 60px;
	}
	.modal-title{
		padding-left: auto;
		padding-right: auto;
		margin-left: auto;
		margin-right: auto;
	}
</style>
