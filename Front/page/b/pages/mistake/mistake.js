const host = require('../../../../config').host
const category = require('../../../../config').category_b
var app = getApp()

var bank = require("../../../../common/bank.js");
var func = require("../../resources/commonFunc.js");
Page({

  /**
   * 页面的初始数据
   */
  data: {
    topic: null,
    nextBtn: 'view_hide',
    mistakeCount:0,
    mistakeIndex:null,
    mistakeLib:null,
    radioState: false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var mistakeLib = wx.getStorageSync("mistakeLib");
    if (mistakeLib.length == 0)
    {
      wx.reLaunch({
        url: 'finish'
      });
      return;
    }
    var mistakeIndex = mistakeLib[0];
    var bankValue = bank.value;
    var topic = func.generateTopic(bankValue[mistakeIndex]);
    var mistakeCount = mistakeLib.length;
    this.setData({
      topic: topic,
      mistakeCount: mistakeCount,
      mistakeLib: mistakeLib,
      mistakeIndex: mistakeIndex
    })
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

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
    //都需要传送答题序列号
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function (e) {
    //都需要传送答题序列号
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
  next: function (e) {
    var mistakeLib = this.data.mistakeLib;
    mistakeLib.shift();
    wx.setStorageSync("mistakeLib", mistakeLib)
    wx.redirectTo({ url: 'mistake'});
  },

  radioChange: function (e) {
    this.setData({
      radioState: true
    })
    var mistakeIndex = this.data.mistakeIndex;
    var mistakeLib = this.data.mistakeLib;
    if (e.detail.value == 'a') {
      wx.showModal({
        title: "正确",
        content: "是否从错题本中移除此题",
        confirmText: "确定",
        cancelText: "取消",
        success: function (res) {
          if (res.confirm) {
            if (app.globalData.openid) {
              var loginid = app.globalData.openid;
              //从错题本中移除
              //  /setMistakeInvalid/{code_loginid}/{category}/{value}/{topicid}
              wx.request({
                url: host + 'setMistakeInvalid/loginid/' + category + '/' + loginid + '/' + mistakeIndex
              })
            }
            else {
              wx.login({
                success: function (res) {
                  var code = res.code;
                  //从错题本中移除
                  //  /setMistakeInvalid/{code_loginid}/{category}/{value}/{topicid}
                  wx.request({
                    url: host + 'setMistakeInvalid/code/' + category + '/' + loginid + '/' + mistakeIndex
                  })
                }
              })
            }
          }
          mistakeLib.shift();
          wx.setStorageSync("mistakeLib", mistakeLib)
          wx.redirectTo({ url: 'mistake' });
        }
      })
    }
    else {
      var that = this;
      wx.showModal({
        title: "正确答案",
        content: this.data.topic.a,
        showCancel: false,
        confirmText: "确定",
        success: function (res) {
          if (res.confirm) {
            that.setData({
              nextBtn: 'view_show'
            })
          }
        }
      })
    }
  }
})