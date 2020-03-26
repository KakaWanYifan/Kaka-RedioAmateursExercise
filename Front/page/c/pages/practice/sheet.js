const host = require('../../../../config').host
const category = require('../../../../config').category_c
var app = getApp()

Page({

  data: {
    topicList: []
  },

  onLoad: function (options) {
    this.setData({
      topicList: wx.getStorageSync('sheet')
    })
  },


  onShow: function () {
  },

  continueAnswer: function () {
    wx.navigateBack();
  }, 

  assignment: function () {
    var topicList = this.data.topicList;
    wx.showLoading({
      title: '正在评分'
    });
    var mistakeList = [];
    var mistakeLkList = [];
    var score = 80;
    var result = new Object();
    for (var i = 0; i < topicList.length; i++) {  //循环LIST
      var item = topicList[i];//获取LIST里面的对象
      if(item.answer != 'a')
      {
        mistakeLkList.push(item.lkid);
        var mistake = new Object();
        var char = item.answer;
        mistake.q = item.q;
        mistake.t = item.a;
        mistake.f = item[char];
        mistake.pic = item.pic
        mistakeList.push(mistake);
        score = score - 1;
      }
      result.mistakeList = mistakeList;
      result.score = score;
    }
    //
    if (app.globalData.openid) {
      var loginid = app.globalData.openid;
      //加入错题本
      wx.request({
        url: host + 'setNewMistakeList',
        data: {
          mistakeList: mistakeLkList.join(","),
          code_loginid: 'loginid',
          category: category,
          value: loginid
        }
      })
      wx.request({
        //    setPractice/{code_loginid}/{category}/{value}/{score}
        url: host + 'setPractice/loginid/' + category + '/' + loginid + '/' + result.score ,
      })
    }
    else {
      wx.login({
        success: function (res) {
          var code = res.code;
          //加入错题本
          wx.request({
            url: host + 'setNewMistakeList',
            data: {
              mistakeList: mistakeLkList.join(","),
              code_loginid: 'code',
              category: category,
              value: code
            }
          })
          wx.request({
            //    setSequence/{code_loginid}/{category}/{value}/{lastSequence}/{thisSequence}
            url: host + 'setPractice/code/' + category + '/' + code + '/' + result.score,
          })
        }
      })
    }
    app.globalData.result = result;
    wx.reLaunch({
      url: 'result',
    })
  }
})