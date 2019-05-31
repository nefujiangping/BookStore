<template>
	<div>
		<div class="loading" v-if="loading">
		    Loading...
		</div>
		<div class="tradeItem" v-else>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>订单编号</th>
						<th>项目编号</th>
						<th>图书</th>
						<th>图书数量</th>
						<th>项目金额</th>
					</tr>
				</thead>
				<tr v-for="item in this.items" v-bind:key="item.itemId">
						<td>{{item.tradeId}}</td>
						<td>{{item.itemId}}</td>
						<td>
							<router-link :to="{ name: 'book_info_page', params: { isbn: item.bookIsbn }}" :title="item.title">
								{{item.title}}
							</router-link>
						</td>
						<td>{{item.quantity}}</td>
						<td>{{item.amount}}</td>
				</tr>
				<tr>
					<td></td>
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
					<td>总金额: {{itemTotalMon}}</td>
				</tr>
			</table>
		</div>
	</div>
</template>

<script>
	export default {
		name: "tradeDetail",
		data() {
			return {
				items: [],
				loading: false
			}
		},
		computed: {
			itemTotalMon() {
				var toMon = 0.
				for(var i=0; i < this.items.length; i++){
					toMon = toMon + this.items[i].amount;
				}
				return toMon;
			}
		},
		methods:{
			getData(){
				this.$http({
				    url: '/getTradeDetail',
				    method: 'get',
				    params: {
						"tradeId": this.$route.params.tradeId
				    },
					responseType: 'json',
				  })
				  .then( (response) => {
					if(response.status == 200){
						console.log(response.data);
						this.items = response.data;
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
