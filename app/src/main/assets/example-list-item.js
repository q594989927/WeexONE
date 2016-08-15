/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};

/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {

/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId])
/******/ 			return installedModules[moduleId].exports;

/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			exports: {},
/******/ 			id: moduleId,
/******/ 			loaded: false
/******/ 		};

/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);

/******/ 		// Flag the module as loaded
/******/ 		module.loaded = true;

/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}


/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;

/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;

/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";

/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ function(module, exports) {

	;__weex_define__("@weex-component/b33616ca13644e0cb6eb428d6efd1a3e", [], function(__weex_require__, __weex_exports__, __weex_module__){

	;
	  __weex_module__.exports = {
	    data: function () {return {
	      title: '',
	      url: ''
	    }},
	    created: function () {
	            var self = this;
	          
	            var bundleUrl = this.$getConfig().bundleUrl;
	            bundleUrl = new String(bundleUrl);
	            var nativeBase;
	            var isAndroidAssets = bundleUrl.indexOf('file://assets/') >= 0;

	            var isiOSAssets = bundleUrl.indexOf('file:///') >= 0 && bundleUrl.indexOf('WeexDemo.app') > 0;
	            if (isAndroidAssets) {
	                nativeBase = 'file://assets/';
	            }
	            else if (isiOSAssets) {
	                nativeBase = bundleUrl.substring(0, bundleUrl.lastIndexOf('/') + 1);
	            }
	            else {
	                var host = 'localhost:12580';
	                var matches = /\/\/([^\/]+?)\//.exec(this.$getConfig().bundleUrl);
	                if (matches && matches.length >= 2) {
	                    host = matches[1];
	                }
	                nativeBase = 'http://' + host + '/' + this.dir + '/build/';
	            }
	            var h5Base = './index.html?page=./' + this.dir + '/build/';
	            var base = nativeBase;
	            if (typeof window === 'object') {
	                base = h5Base;
	            }
	            this.baseURL = base;

	        },
	    methods: {
	      redirect: function() {
	        this.$openURL(this.baseURL+this.url);
	      }
	    }
	  }

	;__weex_module__.exports.template = __weex_module__.exports.template || {}
	;Object.assign(__weex_module__.exports.template, {
	  "type": "div",
	  "events": {
	    "click": "redirect"
	  },
	  "children": [
	    {
	      "type": "text",
	      "classList": [
	        "item-txt"
	      ],
	      "attr": {
	        "value": function () {return this.title}
	      }
	    }
	  ]
	})
	;__weex_module__.exports.style = __weex_module__.exports.style || {}
	;Object.assign(__weex_module__.exports.style, {
	  "item-txt": {
	    "fontSize": 48,
	    "color": "#555555"
	  }
	})
	})
	;__weex_bootstrap__("@weex-component/b33616ca13644e0cb6eb428d6efd1a3e", {
	  "transformerVersion": "0.3.1"
	},undefined)

/***/ }
/******/ ]);