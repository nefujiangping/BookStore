import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Index from '@/components/Index'
import bookInfo from '@/components/bookInfo'
import authorInfo from '@/components/authorInfo'
import publisherInfo from '@/components/publisherInfo'
import shoppingCartInfo from '@/components/shoppingCartInfo'
import checkout from '@/components/Checkout'
import userInfo from '@/components/userInfo'
import tradeDetail from '@/components/tradeDetail'

Vue.use(Router)

export default new Router({
	mode: 'history',
	routes: [
		{
			path: '/login',
			name: 'login_page',
			components: {
				main: Login
			},
			meta: {
				title: '登陆'
			}
		},
		{
			path: '/',
			name: 'index_page',
			components: {
				main: Index
			},
			meta: {
				title: '首页'
			}
		},
		{
			path: '/book/:isbn',
			name: 'book_info_page',
			components: {
				main: bookInfo
			},
			meta: {
				title: '图书信息'
			}
		},
		{
			path: '/author/:authorId',
			name: 'author_info_page',
			components: {
				main: authorInfo
			},
			meta: {
				title: '作者信息'
			}
		},
		{
			path: '/publisher/:publisherId',
			name: 'publisher_info_page',
			components: {
				main: publisherInfo
			},
			meta: {
				title: '出版社信息'
			}
		},
		{
			path: '/shoppingCart',
			name: 'shopping_cart_page',
			components: {
				main: shoppingCartInfo
			},
			meta: {
				title: '购物车'
			}
		},
		{
			path: '/checkout',
			name: 'checkout_page',
			components: {
				main: checkout
			},
			meta: {
				title: '结算'
			}
		},
		{
			path: '/userInfo',
			name: 'user_info_page',
			components: {
				main: userInfo
			},
			meta: {
				title: '用户'
			}
		},
		{
			path: '/tradeDetail/:tradeId',
			name: 'trade_detail_page',
			components: {
				main: tradeDetail
			},
			meta: {
				title: '订单详情'
			}
		},
	]
})
