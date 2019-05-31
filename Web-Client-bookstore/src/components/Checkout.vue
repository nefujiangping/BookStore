<template>
	<div>
		<h4 class="h4" align="center">
			<img src="../assets/chart.svg" width="50px"/>
			您的购物车中共有
			<font color="#e46c0a">{{this.$store.getters.getStateTotalCount}}</font>
			本书
		</h4>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>书名</th>
					<th>数量</th>
					<th>单价</th>
				</tr>
			</thead>
			<tr v-for="item in this.$store.state.cartList" v-bind:key="item.isbn">
					<td>{{item.title}}</td>
					<td><input type="text" alt="item.count"
						class="form-control action-login input-lg" name="item.isbn"
						v-model.number="item.count" onclick="" id="inp_quantity" disabled="disabled"></td>
					<td>{{item.price}}</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td>总金额：<span id="totalMon">{{this.$store.getters.totalMon}}</span></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td>
					<div>
						<router-link :to="{name:'shopping_cart_page'}">
							编辑购物车
						</router-link>&nbsp;
						&nbsp;<button type="button" v-on:click="checkout" class="btn btn-info" id="btn_pay">
							支付
						</button>
					</div>
				</td>
			</tr>
		</table>
	</div>
</template>

<script>
	import toastr from '../assets/js/toastr.min.js'
	$(function(){
		toastr.options = {
			positionClass: 'toast-top-center',
			showDuration: "100",
		}
	})
	export default {
		name: 'checkout',
		data() {
			return {
			}
		},
		methods:{
			checkout (){
				this.$http
					.post('/checkout', {
						userId: this.$store.state.username, // 
						books: this.$store.state.cartList,
						totalMon: this.$store.getters.totalMon,
						totalCount: this.$store.getters.getStateTotalCount
					})
					.then(successResponse => {
					  this.responseResult = JSON.stringify(successResponse.data)
					  if (successResponse.data.code != 0) {
						// this.$router.replace({path: '/index'})
						toastr.error(successResponse.data.message);
					  } else {
						toastr.success(successResponse.data.message);
						this.$store.dispatch("emptyCartFun");
						this.$router.replace({path: '/'});
					  } 
					})
					.catch(failResponse => {
						console.log('Failed!');
					});
			}
		},
		computed:{
		}
	}
</script>

<style scoped>
	@import url("../assets/css/toastr.css");
	#inp_quantity{
		width: 60px;
		text-align: center;
	}
	#totalMon{
		font-weight: bold;
	}
</style>
