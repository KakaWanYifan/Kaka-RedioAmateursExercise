const host = require('../../../../config').host
const category = require('../../../../config').category_c
var app = getApp()

var bank = require("../../../../common/bank.js");
var bankA = require("../../resources/bankA.js");
var func = require("../../resources/commonFunc.js");
Page({

  /**
   * 页面的初始数据
   */
  data: {
    topic:null,
    nextBtn:'view_hide',
    thisIndex:0,
    radioState: false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var thisIndex = options.nextIndex;
    var bankValue = bank.value;
    var bankAValue = bankA.value;
    if (thisIndex >= bankAValue.length)
    {
      wx.reLaunch({
        url: 'finish'
      });
      return;
    }
    var topic = func.generateTopic(bankValue[bankAValue[thisIndex]]);
    var showIndex = parseInt(thisIndex) + 1;
    this.setData({
      topic: topic,
      thisIndex: thisIndex,
      showIndex: showIndex
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

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function (e) {

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
    var nextIndex = parseInt(this.data.thisIndex) + 1;
    wx.redirectTo({url:'sequence?nextIndex=' + nextIndex});
  },

  radioChange: function (e) {
    var lastSequence = parseInt(this.data.thisIndex);
    var thisSequence = parseInt(this.data.thisIndex) + 1;
    if (app.globalData.openid)
    {
      var loginid = app.globalData.openid;
      wx.request({
        //    setSequence/{code_loginid}/{category}/{value}/{lastSequence}/{thisSequence}
        url: host + 'setSequence/loginid/' + category + '/' + loginid + '/' + lastSequence + '/' + thisSequence,
      })
    }
    else
    {
      wx.login({
        success: function (res)
        {
          var code = res.code;
          wx.request({
            //    setSequence/{code_loginid}/{category}/{value}/{lastSequence}/{thisSequence}
            url: 'host' + 'setSequence/code/' + category + '/' + code + '/' + lastSequence + '/' + thisSequence,
          })
        }
      })
    }
    //这个a代表正确选项
    if(e.detail.value == 'a')
    {
      var nextIndex = parseInt(this.data.thisIndex) + 1;
      wx.redirectTo({ url: 'sequence?nextIndex=' + nextIndex })
    }
    else
    {
      this.setData({
        radioState: true
      })
      var bankAValue = bankA.value;
      var topicid = bankAValue[this.data.thisIndex];
      //加入错题本
      if (app.globalData.openid) {
        var loginid = app.globalData.openid;
         wx.request({
           //    /setNewMistake/{code_loginid}/{category}/{value}/{topicid}
           url: host + 'setNewMistake/loginid/' + category + '/' + loginid + '/' + topicid,
         })
      }
      else {
        wx.login({
          success: function (res) {
            var code = res.code;
             wx.request({
               //    setSequence/{code_loginid}/{category}/{value}/{lastSequence}/{thisSequence}
               url: host + 'setNewMistake/code/' + category + '/' + loginid + '/' + topicid,
             })
          }
        })
      }

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