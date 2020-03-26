var bank = require("../../../../common/bank.js");
var bankA = require("../../resources/bankA.js");
var func = require("../../resources/commonFunc.js");
Page({
  /**
   * 页面的初始数据
   */
  data: {
    paper: [],
    sheet: [],
    topicIndex:1
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var arr = [];
    //定义一个while循环，循环的条件是集合arr的子集少于4个
    var i = 1;
    while (arr.length < 50) {
      var t = Math.floor(Math.random() * 694);//生成随机数
      if (arr.indexOf(t) == -1) {
        //如果t在集合arr中存在，indexOf会返回t在集合arr中的位置。
        //如果不存在，indexOf会返回-1
        arr.push(t);    //把生成的数字放进这个数组里
      }
    }
    var paper = [];
    var sheet = [];
    for (var i in arr) {
      var bankValue = bank.value;
      var bankAValue = bankA.value;
      var topic = func.generateTopic(bankValue[bankAValue[arr[[i]]]]);
      topic.id = parseInt(i) + 1;
      topic.lkid = bankAValue[arr[[i]]];
      paper.push(topic);
      sheet.push(topic);
    }
    this.setData({
      paper: paper,
      sheet: sheet
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
  onUnload: function () {
    wx.clearStorageSync();
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

  radioChange: function (e) {
    this.data.sheet[parseInt(e.target.id) - 1].answer = e.detail.value;
  },

  navigate2Sheet: function () {
    wx.setStorageSync('sheet', this.data.sheet);
    wx.navigateTo({
       url: 'sheet'
     })
  }
})