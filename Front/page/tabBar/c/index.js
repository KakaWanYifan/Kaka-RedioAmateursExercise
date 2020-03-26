const host = require('../../../config').host
const category = require('../../../config').category_c

var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list: [
      {
        id: 'sequence',
        name: '顺序刷题',
        open: false,
        desc: '共1071题，已刷0题。',
        pages: [
          {
            zh: '继续上次刷题',
            url: 'sequence/sequence?nextIndex=0'
          }, {
            zh: '重新开始刷题',
            url: 'sequence/sequence?nextIndex=0'
          }
        ]
      }, {
        id: 'practice',
        name: '模拟考试',
        open: false,
        desc: '考试从题库中随机抽取80题，答对60题及以上为合格，考试时间为90分钟。',
        pages: [
          {
            zh: '开始考试',
            url: 'practice/practice'
          }
        ]
      }, {
        id: 'mistake',
        name: '错题本',
        open: false,
        desc: '当前错题本共有0题。',
        pages: [
          {
            zh: '整理错题',
            url: 'mistake/mistake'
          }
        ]
      }
    ],
    mistake: null,
    sequence: 0,
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
        url: host + 'initABC/loginid/' + category + '/' + loginid,
        success: function (res) {
          if (res.data.category == category) {
            list[0].desc = '共1071题，已刷' + res.data.sequence + '题。';
            list[0].pages[0].url = 'sequence/sequence?nextIndex=' + res.data.sequence
            if (res.data.mistake == null) {
              list[2].desc = '当前错题本共有0题。'
            }
            else
            {
              list[2].desc = '当前错题本共有' + res.data.mistake.length + '题。';
              list[2].pages[0].url = 'mistake/mistake';
            }
            wx.setStorageSync("mistakeLib", res.data.mistake)
            that.setData({
              sequence: res.data.sequence,
              mistake: res.data.mistake,
              list: list
            })
          }
          wx.hideLoading();
        }
      })
    }
    else {
      wx.login({
        success: function (res) {
          var code = res.code;
          wx.request({
            url: host + 'initABC/code/' + category + '/' + code,
            success: function (res) {
              if (res.data.category == category) {
                list[0].desc = '共1071题，已刷' + res.data.sequence + '题。';
                list[0].pages[0].url = 'sequence/sequence?nextIndex=' + res.data.sequence
                if (res.data.mistake == null) {
                  list[2].desc = '当前错题本共有0题。'
                }
                else {
                  list[2].desc = '当前错题本共有' + res.data.mistake.length + '题。';
                  list[2].pages[0].url = 'mistake/mistake';
                }
                wx.setStorageSync("mistakeLib", res.data.mistake)
                that.setData({
                  sequence: res.data.sequence,
                  mistake: res.data.mistake,
                  list: list
                })
              }
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