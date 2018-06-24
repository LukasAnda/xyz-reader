package com.example.xyzreader.ui.list;

import com.example.xyzreader.data.UpdaterService;

public class ArticleListPresenter {
    
    private ArticleInterface articleInterface;
    
    public ArticleListPresenter(ArticleInterface articleInterface) {
        this.articleInterface = articleInterface;
    }
    
    public void onArticleListItemClick(long articleId, boolean isRefreshing) {
        if (!isRefreshing)
            articleInterface.showArticleDetails(articleId);
    }
    
    public void onArticlesStateChange(@UpdaterService.ArticlesStatus int articlesStatus) {
        switch (articlesStatus) {
            case UpdaterService.ARTICLES_STATUS_UNKNOWN:
                articleInterface.showProgressBar();
                break;
            case UpdaterService.ARTICLES_STATUS_NETWORK_ERROR:
                articleInterface.onArticlesUpdateFailed("Unable to connect to Internet");
                articleInterface.hideProgressBar();
                break;
            case UpdaterService.ARTICLES_STATUS_SERVER_ERROR:
                articleInterface.onArticlesUpdateFailed("Server Error");
                articleInterface.hideProgressBar();
                break;
            default:
                articleInterface.hideProgressBar();
        }
    }
}
