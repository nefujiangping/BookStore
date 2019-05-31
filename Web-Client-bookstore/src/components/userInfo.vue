<template>
	<div>
		<div class="loading" v-if="loading">
		    Loading...
		</div>
		<div class="user" v-else>
			用户名: {{user.userId}} <br>
			昵称: {{user.displayName}} <br>
			账户余额: {{user.balance}} <br>
			<hr>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>订单编号</th>
						<th>订单时间</th>
						<th>交易额</th>
						<th>操作</th>
					</tr>
				</thead>
				<tr v-for="item in this.trades" v-bind:key="item.tradeId">
						<td>{{item.tradeId}}</td>
						<td>{{item.tradeTime}}</td>
						<td>{{item.tradeAmount}}</td>
						<td>
							<router-link :to="{name:'trade_detail_page', params: { tradeId: item.tradeId }}">
								查看详情
							</router-link>
						</td>
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
					<td>
						<div>
							<span>
								<router-link :to="{name:'index_page'}">
									继续浏览
								</router-link>
							</span>
						</div>
					</td>
					<td></td>
				</tr>
			</table>
		</div>
	</div>
</template>

<script>
	export default {
		name: "userInfo",
		data() {
			return {
				user: {},
				loading: false,
				trades: []
			}
		},
		methods:{
			getData(){
				this.$http({
				    url: '/getUserInfo',
				    method: 'post',
				    params: {
				        "userId": this.$store.state.username // --> userId
				    },
					responseType: 'json',
				  })
				  .then( (response) => {
					if(response.status == 200){
						// console.log(response.data);
						this.user = response.data.user;
						this.trades = response.data.trades;
						this.loading = false;
					}
				  })
				  .catch(function (error) {
				    console.log(error);
				  });
			}
		},
		beforeMount() {
			this.loading = true;
			this.getData();
		}
	}
</script>

<style>
</style>
