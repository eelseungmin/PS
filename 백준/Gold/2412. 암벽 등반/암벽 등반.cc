#include <cstdio>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
 
int n, t;
vector<pair<int, int> > point;
int visit[50001];
 
int myabs(int n) {
    if (n < 0)    return n * -1;
    return n;
}
 
int bfs()
{
    queue<int> que;
    que.push(0);
    visit[0] = 1;
 
    while (!que.empty()) {
        int idx = que.front();
        que.pop();
 
        if (point[idx].second == t) {
            return visit[idx] - 1;
        }
 
        for (int i = idx - 1; i > 0; i--) {
            if (myabs(point[i].first - point[idx].first) > 2)    break;
            if (visit[i] == 0 && myabs(point[i].second - point[idx].second) <= 2) {
                visit[i] = visit[idx] + 1;
                que.push(i);
            }
        }
        for (int i = idx + 1; i <= n; i++) {
            if (myabs(point[i].first - point[idx].first) > 2)    break;
            if (visit[i] == 0 && myabs(point[i].second - point[idx].second) <= 2) {
                visit[i] = visit[idx] + 1;
                que.push(i);
            }
        }
    }
 
    return -1;
}
 
int main()
{
    int x, y;
 
    scanf("%d %d", &n, &t);
 
    point.push_back(make_pair(0, 0));
    for (int i = 0; i < n; i++) {
        scanf("%d %d", &x, &y);
        point.push_back(make_pair(x, y));
    }
 
    sort(point.begin(), point.end());
 
    printf("%d\n", bfs());
 
    return 0;
}