import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);

export default new Vuex.Store({
	state:{
		displayName: "", //nickname
		ifLogin: false, // 记录登陆状态
		totalCount : 0,
		cartList : [],
		username: "", // 储存用户名
		
	},
	getters:{
		getStateTotalCount(state){
			var countSum = 0;
			for(var i=0; i < state.cartList.length; i++){
				countSum = countSum + state.cartList[i].count;
			}
			state.totalCount = countSum;
			return state.totalCount;
		},
		totalMon: function(state){
			var total = 0.
			for(var i=0; i < state.cartList.length; i++){
				total = total + state.cartList[i].price * state.cartList[i].count;
			}
			return total;
		}
	},
	mutations:{
		addCart(state, addArgs) {
		    // 先判断购物车是否已有，如果有，数量+1
		    const isAdded = state.cartList.find(item => item.isbn === addArgs.book.isbn);
		    if (isAdded) {
		        isAdded.count = isAdded.count + addArgs.increment;
		    } else {
		        state.cartList.push({
		            isbn: addArgs.book.isbn,
					title: addArgs.book.title,
					price: addArgs.book.price,
		            count: 1
		        });
		    }
			state.totalCount = state.totalCount + addArgs.increment;
		},
		// 删除商品
		deleteCart (state, isbn) {
		    const index = state.cartList.findIndex(item => item.isbn === isbn);
		    state.cartList.splice(index, 1);
		},
		// 清空购物车
		emptyCart (state) {
		    state.cartList = [];
			state.totalCount = 0;
		},
		setIfLogin: (state, val) => {
			state.ifLogin = val;
		},
		setUsername: (state, name) => {
			state.username = name;
		},
		setDisplayName: (state, displayName) => {
			state.displayName = displayName;
		},
		// 清空缓存
		clearAll(state) {
			state.cartList = [];
			state.ifLogin = false;
			state.username = "";
			state.displayName = "";
		},
	},
	actions:{
		addCartFun(context, addArgs){
			context.commit("addCart", addArgs);
		},
		deleteCartBookFun(context, isbn){
			context.commit("deleteCart", isbn);
		},
		emptyCartFun(context){
			context.commit("emptyCart");
		},
		setUsername: (context, name) => {
			context.commit('setUsername', name);
		},
		setIfLogin: (context, val) => {
			context.commit('setIfLogin', val);
		},
		clearAll: (context) => {
			context.commit('clearAll');
		},
		setDisplayName: (context, displayName) => {
			context.commit('setDisplayName', displayName);
		}
	}
})