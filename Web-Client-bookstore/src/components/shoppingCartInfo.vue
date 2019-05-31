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
					<th>操作</th>
				</tr>
			</thead>
			<tr v-for="item in this.$store.state.cartList" v-bind:key="item.isbn">
					<td>{{item.title}}</td>
					<td><input type="text" alt="item.count"
						class="form-control action-login input-lg" name="item.isbn"
						v-model.number="item.count" onclick="" id="inp_quantity"></td>
					<td>{{item.price}}</td>
					<td><button type="button" v-on:click="deleteBook(item)" class="btn btn-danger" id="btn_delete">
							删除
						</button></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td>总金额：<span id="totalMon">{{this.$store.getters.totalMon}}</span></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td>
					<div>
						<span>
							<router-link :to="{name:'index_page'}">
								继续浏览
							</router-link>
						</span>
						<span>
							<router-link :to="{name:'checkout_page'}">
							结账
						</router-link>
						</span>
						<button type="button" v-on:click="clearCart" class="btn btn-danger" id="btn_clear">
							清空购物车
						</button>
					</div>
				</td>
				<td></td>
			</tr>
		</table>
	</div>
</template>

<script>
	export default {
		methods:{
			clearCart(){
				if(confirm("是否清空购物车?")){
					this.$store.dispatch("emptyCartFun");
					this.$router.replace({path: '/'});
				}
			},
			deleteBook(item){
				if(confirm(`是否从购物车中移除 ${item.title} ?`)){
					this.$store.dispatch("deleteCartBookFun", item.isbn);
					if(this.$store.state.cartList.length === 0){
						this.$router.replace({path: '/'});
					}
				}
			}
		},
		computed:{
		}
	}
</script>

<style scoped>
	#inp_quantity{
		width: 60px;
		text-align: center;
	}
	#totalMon{
		font-weight: bold;
	}
	#btn_delete{
		width: auto;
	}
</style>
