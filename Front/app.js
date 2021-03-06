const host = require('config').host

App({

  //全局变量
  globalData: {
    openid: null,
    result:null
  },

  /**
   * 当小程序初始化完成时，会触发 onLaunch（全局只触发一次）
   */
  onLaunch: function () {
    var that = this;
    wx.login({
      success: function (res) {
        wx.request({
          url:  host +'login/' + res.code, //仅为示例，并非真实的接口地址
          success: function (res) {
            if(res.data.openid)
            {
              that.globalData.openid = res.data.openid
            }
          }
        })
      }
    })
  },

  /**
   * 当小程序启动，或从后台进入前台显示，会触发 onShow
   */
  onShow: function (options) {
    
  },

  /**
   * 当小程序从前台进入后台，会触发 onHide
   */
  onHide: function () {
    
  },

  /**
   * 当小程序发生脚本错误，或者 api 调用失败时，会触发 onError 并带上错误信息
   */
  onError: function (msg) {
    
  }
})
