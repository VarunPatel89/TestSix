package com.app.myapplication.network.responsemodel;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClsGetListResponse
{
    @SerializedName("nbHits")
    private int nbHits;
    @SerializedName("page")
    private int page;
    @SerializedName("nbPages")
    private int nbPages;
    @SerializedName("hitsPerPage")
    private int hitsPerPage;
    @SerializedName("exhaustiveNbHits")
    private boolean exhaustiveNbHits;
    @SerializedName("query")
    private String query;
    @SerializedName("params")
    private String params;
    @SerializedName("processingTimeMS")
    private int processingTimeMS;
    @SerializedName("hits")
    private List<HitsBean> hits;

    public int getNbHits()
    {
        return nbHits;
    }

    public void setNbHits(int nbHits)
    {
        this.nbHits = nbHits;
    }

    public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }

    public int getNbPages()
    {
        return nbPages;
    }

    public void setNbPages(int nbPages)
    {
        this.nbPages = nbPages;
    }

    public int getHitsPerPage()
    {
        return hitsPerPage;
    }

    public void setHitsPerPage(int hitsPerPage)
    {
        this.hitsPerPage = hitsPerPage;
    }

    public boolean isExhaustiveNbHits()
    {
        return exhaustiveNbHits;
    }

    public void setExhaustiveNbHits(boolean exhaustiveNbHits)
    {
        this.exhaustiveNbHits = exhaustiveNbHits;
    }

    public String getQuery()
    {
        return query;
    }

    public void setQuery(String query)
    {
        this.query = query;
    }

    public String getParams()
    {
        return params;
    }

    public void setParams(String params)
    {
        this.params = params;
    }

    public int getProcessingTimeMS()
    {
        return processingTimeMS;
    }

    public void setProcessingTimeMS(int processingTimeMS)
    {
        this.processingTimeMS = processingTimeMS;
    }

    public List<HitsBean> getHits()
    {
        return hits;
    }

    public void setHits(List<HitsBean> hits)
    {
        this.hits = hits;
    }

    public static class HitsBean
    {
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("title")
        private String title;
        @SerializedName("url")
        private String url;
        @SerializedName("author")
        private String author;
        @SerializedName("points")
        private int points;
        @SerializedName("story_text")
        private Object storyText;
        @SerializedName("comment_text")
        private Object commentText;
        @SerializedName("num_comments")
        private int numComments;
        @SerializedName("story_id")
        private Object storyId;
        @SerializedName("story_title")
        private Object storyTitle;
        @SerializedName("story_url")
        private Object storyUrl;
        @SerializedName("parent_id")
        private Object parentId;
        @SerializedName("created_at_i")
        private int createdAtI;
        @SerializedName("objectID")
        private String objectID;
        @SerializedName("_highlightResult")
        private HighlightResultBean highlightResult;
        @SerializedName("_tags")
        private List<String> tags;

        private Boolean isSelected = false;

        public Boolean getSelected()
        {
            return isSelected;
        }

        public void setSelected(Boolean selected)
        {
            isSelected = selected;
        }

        public String getCreatedAt()
        {
            return createdAt;
        }

        public void setCreatedAt(String createdAt)
        {
            this.createdAt = createdAt;
        }

        public String getTitle()
        {
            return title;
        }

        public void setTitle(String title)
        {
            this.title = title;
        }

        public String getUrl()
        {
            return url;
        }

        public void setUrl(String url)
        {
            this.url = url;
        }

        public String getAuthor()
        {
            return author;
        }

        public void setAuthor(String author)
        {
            this.author = author;
        }

        public int getPoints()
        {
            return points;
        }

        public void setPoints(int points)
        {
            this.points = points;
        }

        public Object getStoryText()
        {
            return storyText;
        }

        public void setStoryText(Object storyText)
        {
            this.storyText = storyText;
        }

        public Object getCommentText()
        {
            return commentText;
        }

        public void setCommentText(Object commentText)
        {
            this.commentText = commentText;
        }

        public int getNumComments()
        {
            return numComments;
        }

        public void setNumComments(int numComments)
        {
            this.numComments = numComments;
        }

        public Object getStoryId()
        {
            return storyId;
        }

        public void setStoryId(Object storyId)
        {
            this.storyId = storyId;
        }

        public Object getStoryTitle()
        {
            return storyTitle;
        }

        public void setStoryTitle(Object storyTitle)
        {
            this.storyTitle = storyTitle;
        }

        public Object getStoryUrl()
        {
            return storyUrl;
        }

        public void setStoryUrl(Object storyUrl)
        {
            this.storyUrl = storyUrl;
        }

        public Object getParentId()
        {
            return parentId;
        }

        public void setParentId(Object parentId)
        {
            this.parentId = parentId;
        }

        public int getCreatedAtI()
        {
            return createdAtI;
        }

        public void setCreatedAtI(int createdAtI)
        {
            this.createdAtI = createdAtI;
        }

        public String getObjectID()
        {
            return objectID;
        }

        public void setObjectID(String objectID)
        {
            this.objectID = objectID;
        }

        public HighlightResultBean getHighlightResult()
        {
            return highlightResult;
        }

        public void setHighlightResult(HighlightResultBean highlightResult)
        {
            this.highlightResult = highlightResult;
        }

        public List<String> getTags()
        {
            return tags;
        }

        public void setTags(List<String> tags)
        {
            this.tags = tags;
        }

        public static class HighlightResultBean
        {
            @SerializedName("title")
            private TitleBean title;
            @SerializedName("url")
            private UrlBean url;
            @SerializedName("author")
            private AuthorBean author;

            public TitleBean getTitle()
            {
                return title;
            }

            public void setTitle(TitleBean title)
            {
                this.title = title;
            }

            public UrlBean getUrl()
            {
                return url;
            }

            public void setUrl(UrlBean url)
            {
                this.url = url;
            }

            public AuthorBean getAuthor()
            {
                return author;
            }

            public void setAuthor(AuthorBean author)
            {
                this.author = author;
            }

            public static class TitleBean
            {
                @SerializedName("value")
                private String value;
                @SerializedName("matchLevel")
                private String matchLevel;
                @SerializedName("matchedWords")
                private List<?> matchedWords;

                public String getValue()
                {
                    return value;
                }

                public void setValue(String value)
                {
                    this.value = value;
                }

                public String getMatchLevel()
                {
                    return matchLevel;
                }

                public void setMatchLevel(String matchLevel)
                {
                    this.matchLevel = matchLevel;
                }

                public List<?> getMatchedWords()
                {
                    return matchedWords;
                }

                public void setMatchedWords(List<?> matchedWords)
                {
                    this.matchedWords = matchedWords;
                }
            }

            public static class UrlBean
            {
                @SerializedName("value")
                private String value;
                @SerializedName("matchLevel")
                private String matchLevel;
                @SerializedName("matchedWords")
                private List<?> matchedWords;

                public String getValue()
                {
                    return value;
                }

                public void setValue(String value)
                {
                    this.value = value;
                }

                public String getMatchLevel()
                {
                    return matchLevel;
                }

                public void setMatchLevel(String matchLevel)
                {
                    this.matchLevel = matchLevel;
                }

                public List<?> getMatchedWords()
                {
                    return matchedWords;
                }

                public void setMatchedWords(List<?> matchedWords)
                {
                    this.matchedWords = matchedWords;
                }
            }

            public static class AuthorBean
            {
                @SerializedName("value")
                private String value;
                @SerializedName("matchLevel")
                private String matchLevel;
                @SerializedName("matchedWords")
                private List<?> matchedWords;

                public String getValue()
                {
                    return value;
                }

                public void setValue(String value)
                {
                    this.value = value;
                }

                public String getMatchLevel()
                {
                    return matchLevel;
                }

                public void setMatchLevel(String matchLevel)
                {
                    this.matchLevel = matchLevel;
                }

                public List<?> getMatchedWords()
                {
                    return matchedWords;
                }

                public void setMatchedWords(List<?> matchedWords)
                {
                    this.matchedWords = matchedWords;
                }
            }
        }
    }
}