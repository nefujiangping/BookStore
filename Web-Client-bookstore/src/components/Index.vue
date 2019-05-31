<template>
	<div>
		<div id="div_search" style="background: #bbb;">
			<input type="text" v-model="searchInput" v-on:keyup.enter="search" class="form-control action-login input-lg" id="inp_search" placeholder="输入书名或作者">
			<button type="button" v-on:click="search" class="btn btn-primary" id="btn_search" data-loading-text="搜索中...">
				搜索
			</button>
			<p>
				<img src="../assets/chart.svg" width="50px"/>
				您的
				<router-link :to="{ name: 'shopping_cart_page'}">
				购物车
				</router-link>
				中共有
				<font color="#e46c0a">{{this.$store.getters.getStateTotalCount}}</font>
				本书
			</p>
		</div>
		<div class="loading" v-if="loading">
		    Loading...
		</div>
		<div class="books" v-else>
			<li class="bookItem" v-for="item in books" v-bind:key="item.isbn">
				<img :src="item.imageSrc" />
				<router-link :to="{ name: 'book_info_page', params: { isbn: item.isbn }}" :title="item.title">
					<span><h5 class="title">书名: {{ item.title }}</h5></span>
				</router-link>
				<router-link :to="{ name: 'author_info_page', params: { authorId: item.authorId }}" :title="item.authorName">
					<span>作者: {{ item.authorName }}</span>
				</router-link>
				<span><font color="#888">单价:{{ item.price }}</font></span><br>
				<button type="button" v-on:click="add2cart(item)" 
					class="btn btn-info" 
					id="btn_addtocart" 
					:title="item.authorName">加入购物车</button>
			</li>
		</div>
	</div>
</template>

<script>
	import toastr from '../assets/js/toastr.min.js'
	$(function(){
		toastr.options = {
			positionClass: 'toast-bottom-right',
			showDuration: "100",
		}
	})
	export default {
		name: "Index",
		data() {
			return {
				books: [],
				loading: false,
				searchInput: ''
			}
		},
		methods:{
			add2cart(book){
				var addArgs = {
					book: book,
					increment: 1
				}
				this.$store.dispatch("addCartFun", addArgs)
				toastr.success('成功将《'+book.title+'》加入购物车.');
				console.log(this.$store.getters.getStateCount);
			},
			search(){
				if (this.searchInput.trim()){
					this.$http({
						url: '/search',
						method: 'get',
						params: {
							query: this.searchInput.trim()
						},
						responseType: 'json',
					  })
					  .then( (response) => {
						if(response.status == 200){
							console.log(response.data);
							this.books = response.data;
							this.loading = false;
						}
					  })
					  .catch(function (error) {
						console.log(error);
					  });
				}
			},
			getData(){
				this.$http({
				    url: '/getTopSale',
				    method: 'get',
					responseType: 'json',
				  })
				  .then( (response) => {
					if(response.status == 200){
						console.log(response.data);
						this.books = response.data;
						this.loading = false;
					}
				  })
				  .catch(function (error) {
				    console.log(error);
				  });
			},
			getDataByCategory(){
				this.$http({
				    url: '/category',
				    method: 'get',
					responseType: 'json',
					params: {
					    "category": this.$route.params.category
					},
				  })
				  .then( (response) => {
					if(response.status == 200){
						console.log(response.data);
						this.books = response.data;
						this.loading = false;
					}
				  })
				  .catch(function (error) {
						console.log(error);
				  });
			}
		},
		beforeMount() {
			if(this.$store.state.username == ""){
				toastr.error("请先登陆系统。");
				this.$router.replace({path: '/login'});
			}
			this.loading = true;
			if(this.$route.params.category){
				this.getDataByCategory();
			} else {
				this.getData();
			}
			
		}
	}
</script>

<style scoped>
	@import url("../assets/css/toastr.css");
	#div_search{
		width: 100%;
		padding-left: 10%;
		padding-top: 15px;
		padding-bottom: 15px;
		background-color: #aaa;
		bottom: 15px;
	}
	#div_search p{
		margin-top: 8px;
	}
	#inp_search{
		width: 60%;
		display: inline;
	}
	#btn_search{
		width: auto;
		display: inline;
		height: auto;
		font-size: 12pt;
	}
	#btn_addtocart{
		width: 100px;
		height: 35px;
		padding-left: 0;
		padding-right: 0;
		margin-left: 0;
		margin-right: 0;
		margin-top: auto;
		margin-bottom: auto;
		font-size: 12pt;
	}
	.books{
		margin-left: 30px;
	}
	.bookItem{
		margin-top: 15px;
		margin-left: 35px;
		float: left;
		list-style: none;
	}
	.title{
		margin-top: 25px;
	}
</style>
