// PaperList from an article "Mastering Chess and Shogi by Self-Play with a General Reinforcement Learning Algorithm"
public class PaperList {
    private static final Article[] articles = {
            new Article("J. Baxter, A. Tridgell, and L. Weaver", "Learning to play chess using temporal differences",
                    "Machine Learning", 40, 3, 243, 263, 2000),
            new Article("Donald F. Beal and Martin C. Smith",
                    "Temporal difference learning for heuristic search and game playing",
                    "Inf. Sci.", 122, 1, 3, 21, 2000),
            new Article("Donald F. Beal and Martin C. Smith",
                    "Temporal difference learning applied to game playing and the results of application to shogi",
                    "Theoretical Computer Science", 252, 1 - 2, 105, 119, 2001),
            new Article("M. Campbell, A. J. Hoane, and F. Hsu", "Deep Blue",
                    "Artificial Intelligence", 134, 1 - 2, 57, 83, 2002),
            new Article("Kunihito Hoki and Tomoyuki Kaneko",
                    "Large-scale optimization for evaluation functions with minimax search",
                    "Journal of Artificial Intelligence Research (JAIR)", 49, 527, 568, 2014),
            new Article("Hiroyuki Iida, Makoto Sakuta, and Jeff Rollason", "Computer shogi",
                    "Artificial Intelligence", 134, 121, 144, 2002),
            new Article("D. E. Knuth and R. W Moore", "An analysis of alphabeta pruning",
                    "Artificial Intelligence", 6, 4, 293, 326, 1975),
            new Article("A. L. Samuel",
                    "Some studies in machine learning using the game of checkers II - recent progress",
                    "IBM Journal of Research and Development", 11, 6, 601, 617, 1967),
            new Article("Claude E Shannon", "Xxii. programming a computer for playing chess",
                    "The London, Edinburgh, and Dublin Philosophical Magazine and Journal of Science", 41, 314, 256,
                    275, 1950),
            new Article(
                    "David Silver, Aja Huang, Chris J. Maddison, Arthur Guez, Laurent Sifre, George van den Driessche, Julian Schrittwieser, Ioannis Antonoglou, Veda Panneershelvam, Marc Lanctot, Sander Dieleman, Dominik Grewe, John Nham, Nal Kalchbrenner, Ilya Sutskever, Timothy Lillicrap, Madeleine Leach, Koray Kavukcuoglu, Thore Graepel, and Demis Hassabis",
                    "Mastering the game of Go with deep neural networks and tree search",
                    "Nature", 529, 7587, 484, 489, 2016),
            new Article(
                    "David Silver, Julian Schrittwieser, Karen Simonyan, Ioannis Antonoglou, Aja Huang, Arthur Guez, Thomas Hubert, Lucas Baker, Matthew Lai, Adrian Bolton, Yutian Chen, Timothy Lillicrap, Fan Hui, Laurent Sifre, George van den Driessche, Thore Graepel, and Demis Hassabis",
                    "Mastering the game of go without human knowledge",
                    "Nature", 550, 7676, 354, 359, 2017),
    };

    private static final InProceedings[] inprocs = {
            new InProceedings("Thomas Anthony, Zheng Tian, and David Barber",
                    "Thinking fast and slow with deep learning and tree search",
                    "Advances in Neural Information Processing Systems 30: Annual Conference on Neural Information Processing Systems 2017",
                    5366, 5376, 2017),
            new InProceedings("R. Coulom",
                    "Whole-history rating: A Bayesian rating system for players of time-varying strength",
                    "International Conference on Computers and Games", 113, 124, 2008),
            new InProceedings("Omid E David, Nathan S Netanyahu, and Lior Wolf",
                    "Deepchess: End-to-end deep neural network for automatic learning in chess",
                    "International Conference on Artificial Neural Networks", 88, 96, 2016),
            new InProceedings("Norman P. Jouppi, Cliff Young, Nishant Patil, et al",
                    "In-datacenter performance analysis of a tensor processing unit",
                    "Proceedings of the 44th Annual International Symposium on Computer Architecture ISCA.17", 1, 12,
                    2017),
            new InProceedings("Tomoyuki Kaneko and Kunihito Hoki",
                    "Analysis of evaluation-function learning by comparison of sibling nodes",
                    "Advances in Computer Games - 13th International Conference, ACG 2011", 158, 169, 2011),
            new InProceedings("Sebastian Thrun", "Learning to play the game of chess",
                    "Advances in neural information processing systems", 1069, 1076, 1995),
            new InProceedings("J. Veness, D. Silver, A. Blair, and W. Uther", "Bootstrapping from game tree search",
                    "Advances in Neural Information Processing Systems", 1937, 1945, 2009),
            // ページ番号なしのため除外
            // new InProceedings("Chris J. Maddison, Aja Huang, Ilya Sutskever, and David
            // Silver", "Move evaluation in Go using deep convolutional neural networks",
            // "International Conference on Learning Representations",2015),
            // new InProceedings("Raghuram Ramanujan, Ashish Sabharwal, and Bart Selman",
            // "Understanding sampling style adversarial search methods",
            // "Proceedings of the 26th Conference on Uncertainty in Artificial Intelligence
            // (UAI)",2010),
    };
    private static final Thesis[] theses = {
            new Thesis("Victor Allis", "Searching for Solutions in Games and Artificial Intelligence",
                    "PhD", "University of Limburg, Netherlands", 1994),
            new Thesis("Oleg Arenz", "Monte Carlo chess",
                    "Master's", "Technische Universitat Darmstadt", 2012),
            new Thesis("Matthew Lai", "Giraffe: Using deep reinforcement learning to play chess",
                    "Master's", "Imperial College London", 2015),
    };

    public static void main(String[] args) {
        // タイトルのみ出力
        System.out.printf("=== Title Only ===\n");
        for (int i = 0; i < articles.length; i++) {
            Article ar = articles[i];
            System.out.printf("* %s.\n", ar.title);
        }
        for (int i = 0; i < inprocs.length; i++) {
            InProceedings pr = inprocs[i];
            System.out.printf("* %s.\n", pr.title);
        }
        for (int i = 0; i < theses.length; i++) {
            Thesis th = theses[i];
            System.out.printf("* %s.\n", th.title);
        }

        // 分野別に出力
        System.out.printf("=== Sorted by Category ===\n");
        for (int i = 0; i < articles.length; i++) {
            Article ar = articles[i];
            System.out.printf("* %s:\n", ar.authors);
            System.out.printf("  %s.\n", ar.title);
            if (ar.number > 0) {
                System.out.printf("  %s, Vol. %d, No. %d, pp. %d-%d (%d).\n",
                        ar.journal, ar.volume, ar.number, ar.startpage, ar.endpage, ar.year);
            } else {
                System.out.printf("  %s, Vol. %d, pp. %d-%d (%d).\n",
                        ar.journal, ar.volume, ar.startpage, ar.endpage, ar.year);
            }
        }
        for (int i = 0; i < inprocs.length; i++) {
            InProceedings pr = inprocs[i];
            System.out.printf("* %s:\n", pr.authors);
            System.out.printf("  %s.\n", pr.title);
            System.out.printf("  %s, pp. %d-%d (%d).\n",
                    pr.conference, pr.startpage, pr.endpage, pr.year);
        }
        for (int i = 0; i < theses.length; i++) {
            Thesis th = theses[i];
            System.out.printf("* %s:\n", th.authors);
            System.out.printf("  %s.\n", th.title);
            System.out.printf("  %s Thesis at %s (%d).\n", th.degree, th.school, th.year);
        }

        // 年ごとの出力
        System.out.printf("=== Sorted by Year ===\n");
        for (int year = 2017; year >= 2000; year--) {
            System.out.printf("[Year: %d]\n", year);
            for (int i = 0; i < articles.length; i++) {
                Article ar = articles[i];
                if (ar.year != year)
                    continue;
                System.out.printf("* %s:\n", ar.authors);
                System.out.printf("  %s.\n", ar.title);
                if (ar.number > 0) {
                    System.out.printf("  %s, Vol. %d, No. %d, pp. %d-%d (%d).\n",
                            ar.journal, ar.volume, ar.number, ar.startpage, ar.endpage, ar.year);
                } else {
                    System.out.printf("  %s, Vol. %d, pp. %d-%d (%d).\n",
                            ar.journal, ar.volume, ar.startpage, ar.endpage, ar.year);
                }
            }
            for (int i = 0; i < inprocs.length; i++) {
                InProceedings pr = inprocs[i];
                if (pr.year != year)
                    continue;
                System.out.printf("* %s:\n", pr.authors);
                System.out.printf("  %s.\n", pr.title);
                System.out.printf("  %s, pp. %d-%d (%d).\n",
                        pr.conference, pr.startpage, pr.endpage, pr.year);
            }
            for (int i = 0; i < theses.length; i++) {
                Thesis th = theses[i];
                if (th.year != year)
                    continue;
                System.out.printf("* %s:\n", th.authors);
                System.out.printf("  %s.\n", th.title);
                System.out.printf("  %s Thesis at %s (%d).\n", th.degree, th.school, th.year);
            }
        }
    }
}
