const host = require('../../../config').host
const category = require('../../../config').category_m

var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list: [
      {
        id: 'a',
        name: 'A类学习记录',
        open: false,
        pages: [
          {
            zh: '刷题',
            url: 'sequence/sequence?category=a'
          }, {
            zh: '考试',
            url: 'practice/practice?category=a'
          }, {
            zh: '错题',
            url: 'mistake/mistake?category=a'
          }
        ]
      }, {
        id: 'b',
        name: 'B类学习记录',
        open: false,
        pages: [
          {
            zh: '刷题',
            url: 'sequence/sequence?category=b'
          }, {
            zh: '考试',
            url: 'practice/practice?category=b'
          }, {
            zh: '错题',
            url: 'mistake/mistake?category=b'
          }
        ]
      }, {
        id: 'c',
        name: 'C类学习记录',
        open: false,
        pages: [
          {
            zh: '刷题',
            url: 'sequence/sequence?category=c'
          }, {
            zh: '考试',
            url: 'practice/practice?category=c'
          }, {
            zh: '错题',
            url: 'mistake/mistake?category=c'
          }
        ]
      }
    ],
    category: category
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    wx.showLoading({
      title: 'Loading'
    });
    var that = this;
    var list = this.data.list;
    if (app.globalData.openid) {
      var loginid = app.globalData.openid;
      wx.request({
        //  getChart/{code_loginid}/{value}
        url: host + 'getChart/loginid/' + loginid,
        success: function (res) {
          wx.setStorageSync('data',res.data);
          wx.hideLoading();
        }
      })
    }
    else {
      wx.login({
        success: function (res) {
          var code = res.code;
          wx.request({
            url: host + 'getChart/code/' + code,
            success: function (res) {
              wx.setStorageSync('data', res.data);
              wx.hideLoading();
            }
          })
        }
      })
    }
  },


  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  kindToggle: function (e) {
    var id = e.currentTarget.id, list = this.data.list;
    for (var i = 0, len = list.length; i < len; ++i) {
      if (list[i].id == id) {
        list[i].open = !list[i].open
      } else {
        list[i].open = false
      }
    }
    this.setData({
      list: list
    });
  }
})