<template>
	<div>
		<div class="loading" v-if="loading">
		    Loading...
		</div>
		<div class="publisher" v-else>
			出版社: {{publisher.publisherName}} <br>
			出版社简介: {{publisher.publisherIntro}} <br>
		</div>
	</div>
</template>

<script>
	export default {
		name: "publisherInfo",
		data() {
			return {
				publisher: {},
				loading: false
			}
		},
		methods:{
			getData(){
				this.$http({
				    url: '/getPublisherInfo',
				    method: 'get',
				    params: {
				        "publisherId": this.$route.params.publisherId
				    },
					responseType: 'json',
				  })
				  .then( (response) => {
					if(response.status == 200){
						console.log(response.data);
						this.publisher = response.data;
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
