// 简化js原生选择器
function $(selector) { return document.querySelector(selector); }
function $$(selector) { return document.querySelectorAll(selector); }
// 读写Hash值(val未赋值时为读取)
function hashParam(key, val) {
	let hashstr = decodeURIComponent(window.location.hash);
	let regKey = new RegExp(`${key}=([^&]*)`);
	let getVal = regKey.test(hashstr) ? hashstr.match(regKey)[1] : null;
	if (val == undefined) return getVal;
	if (hashstr == '' || hashstr == '#') {
		window.location.hash = `#${key}=${val}`;
	}
	else {
		if (getVal) window.location.hash = hashstr.replace(getVal, val);
		else {
			window.location.hash = hashstr.indexOf(key) > -1 ? hashstr.replace(regKey, `${key}=${val}`) : `${hashstr}&${key}=${val}`;
		}
	}
}
var nowTabName = '首页';
// 选项卡Tab切换事件处理
function showTab(tabName) {
    nowTabName = tabName
	$$('.tabtitle>*').forEach(node => { node.className = node.className.replace(' this', ''); });
	$$('.tabbody>*').forEach(node => { node.className = node.className.replace(' this', ''); });
	$(`.tabbody>.${$(`.tabtitle>*[name=${tabName}]`).className}`).className += ' this';
	$(`.tabtitle>*[name=${tabName}]`).className += ' this';

    $$('.tabtitle0>*').forEach(node => { node.className = node.className.replace(' this', ''); });
    $$('.tabbody0>*').forEach(node => { node.className = node.className.replace(' this', ''); });
    $(`.tabbody0>.${$(`.tabtitle0>*[name=${tabName}]`).className}`).className += ' this';
    $(`.tabtitle0>*[name=${tabName}]`).className += ' this';

	hashParam('tab', tabName);
}
// 页面加载完成事件
window.onload = () => {
	$$('.tabtitle>*').forEach(item => {
		item.addEventListener('click', () => {
			showTab(item.innerHTML);
		});
	});
	if (hashParam('tab')) showTab(hashParam('tab'));
}
// 获取数据
function HttpGet(url) {
	return fetch(hashParam('domain') ? hashParam('domain') + url : url)
		.then(res => res.json()).catch(err => console.error('Error:', err));
}
// 提交数据
function HttpPost(url, data, jsonFormat) {
	return fetch(hashParam('domain') ? hashParam('domain') + url : url, {
		body: jsonFormat == true ? JSON.stringify(data) : data,
		method: 'POST',
		mode: "cors",
		headers: new Headers({
			'Content-Type': 'application/json;charset=utf-8'
		})
	}).then(res => res.json()).catch(err => console.error('Error:', err));
}
function todo() {
}
// 处理按钮点击事件
$('.menu').addEventListener('click', e => {
	let thisNode = e.target;
	thisNode = thisNode.parentNode.nodeName == 'svg' ? thisNode.parentNode.querySelector('rect') :
		thisNode.nodeName == 'svg' ? thisNode.querySelector('rect') : null;
	if (!thisNode) return;
	if (thisNode.getAttribute('class') == 'busy') return;
	thisNode.setAttribute('class', 'busy');
	switch (thisNode.id) {
	    case 'encry':
	        let classIdEncry = '';
	        let classIdDecry = '';
            switch (nowTabName) {
                 case '首页':
                     classIdDecry = '#RuleIndexStringDecry';
                     classIdEncry = '#RuleIndexStringEncry';
                     break;
                 case '详情':
                     classIdDecry = '#RuleSeasonStringDecry';
                     classIdEncry = '#RuleSeasonStringEncry';
                     break;
                 case '分类':
                     classIdDecry = '#RuleCategoryStringDecry';
                     classIdEncry = '#RuleCategoryStringEncry';
                     break;
                 case '直播':
                     classIdDecry = '#RuleLiveStringDecry';
                     classIdEncry = '#RuleLiveStringEncry';
                     break;
                 case '下载':
                     classIdDecry = '#RuleDownloadStringDecry';
                     classIdEncry = '#RuleDownloadStringEncry';
                     break;
                 default:
            }

            (async () => {
            	await HttpPost(`/str2Encrypt`, $(classIdDecry).value, false).then(json => {
            		if (json.isSuccess) {
            		    $(classIdEncry).value = json.data;
            		}
            		else {
            			alert(`加密失败!\nErrorMsg: ${json.errorMsg}`);
            		}
            	}).catch(err => { alert(`生成站源失败,无法连接到APP !\n${err}`); });
            	thisNode.setAttribute('class', '');
            })();
	        return;
	    case 'decry':
	        let classIdEncry2 = '';
        	let classIdDecry2 = '';
            switch (nowTabName) {
                 case '首页':
                     classIdDecry2 = '#RuleIndexStringDecry';
                     classIdEncry2 = '#RuleIndexStringEncry';
                     break;
                 case '详情':
                     classIdDecry2 = '#RuleSeasonStringDecry';
                     classIdEncry2 = '#RuleSeasonStringEncry';
                     break;
                 case '分类':
                     classIdDecry2 = '#RuleCategoryStringDecry';
                     classIdEncry2 = '#RuleCategoryStringEncry';
                     break;
                 case '直播':
                     classIdDecry2 = '#RuleLiveStringDecry';
                     classIdEncry2 = '#RuleLiveStringEncry';
                     break;
                 case '下载':
                     classIdDecry2 = '#RuleDownloadStringDecry';
                     classIdEncry2 = '#RuleDownloadStringEncry';
                     break;
                 default:
            }
            (async () => {
            	await HttpPost(`/str2Decrypt`, $(classIdEncry2).value, false).then(json => {
            		if (json.isSuccess) {
            		    $(classIdDecry2).value = json.data;
            		}
            		else {
            			alert(`解密失败!\nErrorMsg: ${json.errorMsg}`);
            		}
            	}).catch(err => { alert(`解密失败,无法连接到APP !\n${err}`); });
            	thisNode.setAttribute('class', '');
            })();
            return;
		case 'push':
			let getUrl5 = ``;
            let classId5 = '';
            switch (nowTabName) {
                 case '首页':
                     getUrl5 = `/saveIndexSource`;
                     classId5 = '#RuleIndexStringDecry';
                     break;
                 case '详情':
                     getUrl5 = `/saveSeasonSource`;
                     classId5 = '#RuleSeasonStringDecry';
                     break;
                 case '分类':
                     getUrl5 = `/saveCategorySource`;
                     classId5 = '#RuleCategoryStringDecry';
                     break;
                 case '直播':
                     getUrl5 = `/saveLiveSource`;
                     classId5 = '#RuleLiveStringDecry';
                     break;
                 case '下载':
                     getUrl5 = `/saveDownloadSource`;
                     classId5 = '#RuleDownloadStringDecry';
                     break;
                 default:
            }
			(async () => {
				await HttpPost(getUrl5, $(classId5).value, false).then(json => {
					if (json.isSuccess) {
					    alert(`推送站源成功 !`);
                    }
					else {
						alert(`推送站源失败!\nErrorMsg: ${json.errorMsg}`);
					}
				}).catch(err => { alert(`推送站源失败,无法连接到APP !\n${err}`); });
				thisNode.setAttribute('class', '');
			})();
			return;
		case 'pull':
		    let getUrl = ``;
		    let classId = '';
            switch (nowTabName) {
                 case '首页':
                     getUrl = `/getIndexSource`;
                     classId = '#RuleIndexStringDecry';
                     break;
                 case '详情':
                     getUrl = `/getSeasonSource`;
                     classId = '#RuleSeasonStringDecry';
                     break;
                 case '分类':
                     getUrl = `/getCategorySource`;
                     classId = '#RuleCategoryStringDecry';
                     break;
                 case '直播':
                     getUrl = `/getLiveSource`;
                     classId = '#RuleLiveStringDecry';
                     break;
                 case '下载':
                     getUrl = `/getDownloadSource`;
                     classId = '#RuleDownloadStringDecry';
                     break;
                 default:
            }
			(async () => {
				await HttpGet(getUrl).then(json => {
					if (json.isSuccess) {
					   $(classId).value = json.data;
					}else {
						alert(`拉取站源失败!\nErrorMsg: ${json.errorMsg}`);
					}
				}).catch(err => { alert(`拉取站源失败,无法连接到APP !\n${err}`); });
				thisNode.setAttribute('class', '');
			})();
			return;
		case 'initial':
		    let classIdEncry3 = '';
            let classIdDecry3 = '';
            switch (nowTabName) {
                 case '首页':
                     classIdDecry3 = '#RuleIndexStringDecry';
                     classIdEncry3 = '#RuleIndexStringEncry';
                     break;
                 case '详情':
                     classIdDecry3 = '#RuleSeasonStringDecry';
                     classIdEncry3 = '#RuleSeasonStringEncry';
                     break;
                 case '分类':
                     classIdDecry3 = '#RuleCategoryStringDecry';
                     classIdEncry3 = '#RuleCategoryStringEncry';
                     break;
                 case '直播':
                     classIdDecry3 = '#RuleLiveStringDecry';
                     classIdEncry3 = '#RuleLiveStringEncry';
                     break;
                 case '下载':
                     classIdDecry3 = '#RuleDownloadStringDecry';
                     classIdEncry3 = '#RuleDownloadStringEncry';
                     break;
                 default:
            }
            $(classIdEncry3).value = '';
            $(classIdDecry3).value = '';
            thisNode.setAttribute('class', '');
			return;
		default:
	}
	setTimeout(() => { thisNode.setAttribute('class', ''); }, 500);
});