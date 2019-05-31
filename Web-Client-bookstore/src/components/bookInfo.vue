<template>
	<div>
		<div id="div_cart">
			<img src="../assets/chart.svg" width="50px"/>
			您的
			<router-link :to="{ name: 'shopping_cart_page'}">
			购物车
			</router-link>
			中共有
			<font color="#e46c0a">{{this.$store.getters.getStateTotalCount}}</font>
			本书
		</div>
		<div class="loading" v-if="loading">
		    Loading...
		</div>
		<div class="book" v-else>
			图书类别 >> 
			<router-link :to="{ name: 'index_page', params: { category: book.category }}" :title="book.category">
				<span>{{ book.category }} </span>
			</router-link> <br>
			书名: {{book.title}} <br>
			<router-link :to="{ name: 'author_info_page', params: { authorId: book.authorId }}" :title="book.authorName">
				<span>作者: {{ book.authorName }}</span>
			</router-link><br>
			<router-link :to="{ name: 'publisher_info_page', params: { publisherId: book.publisherId }}" :title="book.publisherName">
				出版社: {{book.publisherName}} <br>
			</router-link>
			出版时间: {{ book.publishDate }} <br>
			库存: {{ book.inventory }} <br>
			销量: {{ book.numberSale }} <br>
			<font color="#888">单价:{{ book.price }}</font> <br>
			<hr/>
			<h4>图书简介:</h4>
			{{ book.description }}
		</div>
		<hr />
		<div id="div_bottom">
			<button type="button" v-on:click="add2cart(book)" 
				class="btn btn-info" 
				id="btn_addtocart"
				:title="book.authorName">加入购物车</button>
			&nbsp;
			<router-link :to="{name:'index_page'}">
				继续浏览
			</router-link>
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
		name: "bookInfo",
		data() {
			return {
				book: {},
				loading: false
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
				console.log(this.$store.getters.getStateCount)
			},
			getData(){
				this.$http({
				    url: '/getBookInfo',
				    method: 'get',
				    params: {
				        "isbn": this.$route.params.isbn
				    },
					responseType: 'json',
				  })
				  .then( (response) => {
					if(response.status == 200){
						console.log(response.data);
						this.book = response.data;
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

<style scoped>
	@import url("../assets/css/toastr.css");
	.loading, .book{
		margin-top: 15px;
	}
	#div_cart{
		margin-top: 15px;
		margin-left: auto;
		margin-right: auto;
	}
	#btn_addtocart{
		margin-bottom: 15px;
	}
	#div_bottom{
		margin-left: 20%;
	}
</style>
