<template>
	<div>
		<div class="loading" v-if="loading">
		    Loading...
		</div>
		<div class="author" v-else>
			作者: {{authorInfo.author.authorName}} <br>
			作者简介: {{authorInfo.author.authorIntro}} <br>
			<hr />
			<h4>畅销书:</h4>
			<ol>
				<h5>
				<li v-for="book in authorInfo.topSaleBooks" v-bind:key="book.isbn">
					<router-link :to="{ name: 'book_info_page', params: { isbn: book.isbn }}" :title="book.title">
						<span>{{ book.title }}</span>
					</router-link>
				</li>
				</h5>
			</ol>
		</div>
	</div>
</template>

<script>
	export default {
		name: "authorInfo",
		data() {
			return {
				authorInfo: {},
				loading: false
			}
		},
		methods:{
			getData(){
				this.$http({
				    url: '/getAuthorInfo',
				    method: 'get',
				    params: {
				        "authorId": this.$route.params.authorId
				    },
					responseType: 'json',
				  })
				  .then( (response) => {
					if(response.status == 200){
						console.log(response.data);
						this.authorInfo = response.data;
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
