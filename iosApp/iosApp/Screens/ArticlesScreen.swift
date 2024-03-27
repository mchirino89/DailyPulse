//
//  ArticlesScreen.swift
//  iosApp
//
//  Created by Mauricio Chirino on 27/3/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ArticlesScreen: View {
    @ObservableObject private(set) var viewModel: ArticlesViewModelWrapper

    var body: some View {
        VStack {
            AppBar()

            if viewModel.articlesState.loading {
                Loader()
            }

            if let error = viewModel.articlesState.error {
                ErrorMessage(message: error)
            }

            if !viewModel.articlesState.isEmpty {
                ScrollView {
                    LazyVStack(spacing: 10) {
                        ForEach(viewModel.articlesState.articles, id: \.self) { articles in
                            ArticlesItemView(articles: articles)
                        }
                    }
                }
            }
        }.onAppear {
            self.viewModel.startObserving()
        }
    }
}

struct AppBar: View {
    var body: some View {
        Text("Articles")
            .font(.largeTitle)
            .fontWeight(.bold)
    }
}

struct Loader: View {
    var body: some View {
        ProgressView()
            .progressViewStyle(CircularProgressViewStyle())
            .scaleEffect(2)
    }
}

struct ErrorMessage: View {
    let message: String

    var body: some View {
        Text(message)
            .font(.title)
    }
}

struct ArticlesItemView: View {
    let article: Article

    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            AsyncImage(url: URL(string: article.imageUrl)) { phase in

                if phase.image != nil {
                    phase.image!
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                } else if phase.error != nil {
                    Text("Image Load Error")
                } else {
                    ProgressView()
                }

            }
            Text(article.title)
                .font(.title)
                .fontWeight(.bold)
            Text(article.description)
            Text(article.date)
                .frame(maxWidth: .infinity, alignment: .trailing)
                .foregroundColor(.gray)
        }
    }
}

#Preview {
    ArticlesScreen()
}
